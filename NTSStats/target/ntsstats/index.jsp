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
	background-color: orange;
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
h3{
	text-align: center;
}

select {
    width: 80%;
    padding: 16px 20px;
    border: none;
    border-radius: 4px;
    background-color: #f1f1f1;
	cursor: pointer;
}
input[type=submit] {
    width: 50%;
    background-color: darkgray;
    color: black;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
input[type=submit]:hover {
    background-color: gray;
	color: black
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
	text-align: center;
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

<p align=center><img src="images/LogoClear.png"
style="width:150px;height:150px"></p>

<h1>No Tech Skill Stats</h1>
<br>

<div class="row">
  	<div class="column">
		<h2>Player Stats</h2>
		<form>
			<select id="players" name="players">
				<%
					ArrayList<Player> players = PlayersDAO.getAll();
					int count = 0;
					
					while (players.size() > count) {
				%>
				<option value="<%= players.get(count).getId() %>"><%= players.get(count).getFirstName() + " " + players.get(count).getLastName() %></option>
				<%count++;
				} %>
			</select>
			<br>
			<br>
			<input type="submit" formaction="http://localhost:8080/NTSStats/NTSPlayerStats.jsp" value="Go">
		</form>
	</div>
	<div class="column">
    	<h2>Head to Head Record</h2>
		<form>
			<select id="player1" name="player1">
				<%
					count = 0;
					
					while (players.size() > count) {
				%>
				<option value="<%= players.get(count).getId() %>"><%= players.get(count).getFirstName() + " " + players.get(count).getLastName() %></option>
				<%count++;
				} %>
			</select>
		<h3>VS</h3>
			<select id="player2" name="player2">
				<%
					count = 0;
					
					while (players.size() > count) {
				%>
				<option value="<%= players.get(count).getId() %>"><%= players.get(count).getFirstName() + " " + players.get(count).getLastName() %></option>
				<%count++;
				} %>
			</select>
			<br>
			<br>
			<input type="submit" formaction="http://localhost:8080/NTSStats/NTSHeadToHead.jsp" value="Go">
		</form>
  	</div>
  	<div class="column">
    	<h2>Tournaments</h2>
		<form>
			<select id="tournaments" name="tournaments">
				<%
					ArrayList<Tournament> tournaments = TournamentsDAO.getAll();
					count = 0;
					
					while (tournaments.size() > count) {
				%>
				<option value="<%= tournaments.get(count).getId() %>"><%= tournaments.get(count).getName() %></option>
				<%count++;
				} %>
			</select>
			<br>
			<br>
			<input type="submit" formaction="http://localhost:8080/NTSStats/NTSTournaments.jsp" value="Go">
		</form>
  	</div>
</div>

<div class="push"></div>
</div>

<footer class="footer">
  	<p>No Tech Skill 2018. Updated to NTSC2. Created by Matt Derzay.</p>
</footer>

</body>
</html>