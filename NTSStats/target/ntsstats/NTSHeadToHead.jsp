<html lang="en-US">
<head>

<title>NTS Stats</title>

<style>

html, body {
  height: 100%;
  margin: 0;
}
.wrapper {
  min-height: 100%;
  margin-bottom: -50px;
}
.footer {
	height: 50px;
	background-color:orange;
	padding: 1px;
	text-align: center;
}
.push {
  height: 50px;
}

h1 {
	color: Black;
	text-align: center;
}
h2{
	color: gray;
	text-align: center;
}

.navbar {
	overflow:hidden;
	background-color: orange;
}
.navbar a {
    float: left;
    display: block;
    color: black;
    text-align: center;
  	padding: 14px 16px;
	text-decoration: none;
}
.navbar a:hover {
    background-color: darkorange;
    color: black;
}

</style>
</head>
<body>

<%@ page import="org.matt.ntsstats.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<div class="wrapper">

<div class="navbar">
	<a href="http://localhost:8080/NTSStats/">Home</a>
	<a href="http://challonge.com/users/phazon825">Brackets</a>
	<a href="https://www.youtube.com/channel/UC95ObYqgI1dTWq1oONoc-Hg/featured">Vods</a>
  	<a href="http://localhost:8080/NTSStats/NTSContact.jsp">Contact</a>
  	<a href="http://localhost:8080/NTSStats/NTSAbout.jsp">About</a>
</div>

<% int pId1 = Integer.parseInt(request.getParameter("player1")); %>
<% int pId2 = Integer.parseInt(request.getParameter("player2")); %>
<% Player player1 = PlayersDAO.getPlayerInfo(pId1); %>
<% Player player2 = PlayersDAO.getPlayerInfo(pId2); %>

<h1><%= player1.getFirstName() + " " + player1.getLastName() + "   ~   VS   ~   " + player2.getFirstName() + " " + player2.getLastName() %></h1>
<h2>
	<% 
		ArrayList<String> record = SetsDAO.versusRecord(pId1, pId2);
		int count = 0;
					
		while (record.size() > count) {
	%>
	<%= record.get(count) %><br><br>
	<% count++; } 
	%></h2>

<div class="push"></div>
</div>

<footer class="footer">
	<p>No Tech Skill 2018. Updated to NTSC2. Created by Matt Derzay.</p>
</footer>

</body>
</html>