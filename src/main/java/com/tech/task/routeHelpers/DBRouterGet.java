/**
 * 
 */
package com.tech.task.routeHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.task.models.Employee;

/**
 * @author C5107958
 *
 */
public class DBRouterGet extends RouteBuilder {
	@Autowired
	DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void configure() throws Exception {
		
		from("direct:getEmployee")
		.setBody(constant("select * from Employee"))
		.to("jdbc:dataSource")
		
		//.split().simple("${body}")
		.log("process row ${body}")
		.process(new Processor(){

			public void process(Exchange xchg) throws Exception {
				
			List<Map<String, Object>> rows = xchg.getIn().getBody(List.class);
				ArrayList<Employee> empList   = new ArrayList<>();
				System.out.println("Processing....."+rows);
						for(Map<String,Object> row : rows) {
						  Employee emp = new Employee();
						  emp.setId(row.get("ID").toString()); 
						  emp.setName(row.get("NAME").toString());
						  emp.setDob(row.get("DOB").toString());
						  emp.setSalary((Integer)row.get("SALARY"));
						  System.out.println("Employee: "+ emp);
						  empList.add(emp);
						}
						ObjectMapper mapper = new ObjectMapper();
						String response = mapper.writeValueAsString(empList);
						xchg.getIn().setBody(response);
			}
			
		});
		//.to("mock:result");
		
	}
	
	
}
