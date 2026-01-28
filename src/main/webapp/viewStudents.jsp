<%@ page import="java.sql.*" %>
<%
Connection con = com.grading.DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(
"SELECT s.name, s.roll_no, sub.subject_name, sub.marks, sub.grade " +
"FROM students s JOIN subjects sub ON s.id=sub.student_id");
%>

<table border="1">
<tr>
<th>Name</th><th>Roll</th><th>Subject</th><th>Marks</th><th>Grade</th>
</tr>

<% while(rs.next()) { %>
<tr>
<td><%= rs.getString(1) %></td>
<td><%= rs.getString(2) %></td>
<td><%= rs.getString(3) %></td>
<td><%= rs.getInt(4) %></td>
<td><%= rs.getString(5) %></td>
</tr>
<% } %>
</table>
