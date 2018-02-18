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
	text-decoration: underline;
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

.column {
    float: left;
    width: 33.33%;
	color: black;
	text-align:center;
}
.row:after {
	content: "";
    display: table;
    clear: both;
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

<% int pId = Integer.parseInt(request.getParameter("players")); %>
<% Player player = PlayersDAO.getPlayerInfo(pId); %>

<h1><%= player.getFirstName() + " " + player.getLastName() %></h1>

<div class="row">
  	<div class="column">
 		<h2>Results</h2>
		<h3>
		<%
			ArrayList<Placing> placings = PlayersDAO.getPlayerResults(pId);
			Tournament tournament;
			int count = 0;
					
			while (placings.size() > count) {
				tournament = TournamentsDAO.getTournamentInfo(placings.get(count).getTournament());
			%>
			<%= PlacingsDAO.betterPlacing(placings.get(count).getPlacing()) + " - " + TournamentsDAO.shorten(tournament.getName()) %><br>
			<%count++; } 
		%></h3>
	</div>
	<div class="column">
		<% int[] record = SetsDAO.playerRecord(pId); %>
    	<h2>Set Count</h2>
		<h3><%= record[0] + " - " + record[1] %></h3>
		<h2>Win Percentage</h2>
		<h3><%= SetsDAO.winPercentage(record) + "%"%></h3>
		<h2>Main/Secondaries</h2>
		<h3>
		<%
			ArrayList<String> mains = PlayersDAO.listMains(pId);
			count = 0;
					
			while (mains.size() > count) {
		%>
		<%= mains.get(count) %><br>
		<%count++; } 
		%></h3>

  	</div>
  	<div class="column">
    	<h2>Wins</h2>
		<h3>
		<%
			ArrayList<String> wins = SetsDAO.playerWins(pId);
			count = 0;
					
			while (wins.size() > count) {
		%>
		<%= wins.get(count) %><br>
		<%count++; } 
		%></h3>
		<h2>Losses</h2>
		<h3>
		<%
			ArrayList<String> loses = SetsDAO.playerLoses(pId);
			count = 0;
					
			while (loses.size() > count) {
		%>
		<%= loses.get(count) %><br>
		<%count++; } 
		%></h3>
  	</div>
</div>

<div class="push"></div>
</div>

<footer class="footer">
	<p>No Tech Skill 2018. Updated to NTSC2. Created by Matt Derzay.</p>
</footer>

</body>
</html>