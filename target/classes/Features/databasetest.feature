Feature: Database test

  @databasetest @regression @controllertest
  Scenario Outline: We should be able connect to the database and get the data
    When connection is established using <url> <driver> <username> and <password>
    And I run a select query to get the <columnName> using <queryColumnName> to get the data from <tableName> where <queryColumn>
    Then I should see the result as <columnValue>

    Examples: |
      | url                                         | driver                  | username   | password | columnName     | queryColumnName | tableName  | columnValue | queryColumn |
      | "jdbc:mysql://localhost:3306/revaturejwadb" | "com.mysql.jdbc.Driver" | "root"     | "root"   | "product_Name" | "product_Id"    | "products" | "Monitor"   |           3 |
      | "jdbc:mysql://localhost:3306/maybankdb"     | "com.mysql.jdbc.Driver" | "root"     | "root"   | "Ename"        | "EmpId"         | "employee" | "Mohan"     |          11 |
      | "jdbc:postgresql://localhost:5432/postgres" | "org.postgresql.Driver" | "postgres" | "root"   | "first_name"   | "id"            | "student"  | "Ahmed"     |           1 |
## select product_Name from products where product_Id = 3
## result columnValue - Monitor
