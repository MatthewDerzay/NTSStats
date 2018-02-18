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
  	<a href="#">Contact</a>
  	<a href="#">About</a>
</div>

<% int tId = Integer.parseInt(request.getParameter("tournaments")); %>
<% Tournament tournament = TournamentsDAO.getTournamentInfo(tId); %>

<h1><%= tournament.getName() %></h1>
<h2><%= TournamentsDAO.betterDate(tournament.getDate()) %></h2>
<br>
<h2>
	<%
		ArrayList<Placing> placings = PlacingsDAO.getTournamentPlacings(tId);
		Player player;
		int count = 0;
					
		while (placings.size() > count) {
			player = PlayersDAO.getPlayerInfo(placings.get(count).getPlayer());
		%>
		<%= PlacingsDAO.betterPlacing(placings.get(count).getPlacing()) + " - " + player.getFirstName() + " " + player.getLastName() %><br>
		<%count++; } 
	%>
</h2>

<div class="push"></div>
</div>

<footer class="footer">
	<p>No Tech Skill 2018. Updated to NTSC2. Created by Matt Derzay.</p>
</footer>

</body>
</html>