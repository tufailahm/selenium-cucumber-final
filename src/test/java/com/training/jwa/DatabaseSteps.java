package com.training.jwa;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatabaseSteps {

	Connection connection;
	Statement statement;
	ResultSet res;

	String QUERY;

	@When("connection is established using {string} {string} {string} and {string}")
	public void connection_is_established_using_and(String url, String driver, String username, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
	}

	@When("I run a select query to get the {string} using {string} to get the data from {string} where {int}")
	public void i_run_a_select_query_to_get_the_using_to_get_the_data_from_where(String columnName,
			String queryColumnName, String tableName, Integer queryColumn) throws SQLException {

		QUERY = "select " + columnName + " from " + tableName + " where " + queryColumnName + " = " + queryColumn;
		// select <columnName> from <tableName> where <queryColumnName> = <columnValue>

		statement = connection.createStatement();
		res = statement.executeQuery(QUERY);

	}

	@Then("I should see the result as {string}")
	public void i_should_see_the_result_as(String columnValue) throws SQLException {
		res.next();
		String expected = columnValue;
		String actual = res.getString(1);
		
		assertEquals(expected, actual);
	}

}
