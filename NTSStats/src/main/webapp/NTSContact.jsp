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

<div class="wrapper">

<div class="navbar">
	<a href="http://localhost:8080/NTSStats/">Home</a>
	<a href="http://challonge.com/users/phazon825">Brackets</a>
	<a href="https://www.youtube.com/channel/UC95ObYqgI1dTWq1oONoc-Hg/featured">Vods</a>
  	<a href="http://localhost:8080/NTSStats/NTSContact.jsp">Contact</a>
  	<a href="http://localhost:8080/NTSStats/NTSAbout.jsp">About</a>
</div>

<h1>Let me know what you think</h1>
<h2>Found a stat that isn't correct, changed mains, picked up a secondary, or just want to let me know<br> 
	what you like or dislike? Also let me know if you have any ideas to improve the site. Use the form<br> 
	below to contact me directly. This will not change any information immediately.</h2>

<form method="post" enctype="text/plain">
Name:<br>
<input type="text" name="name"><br>
E-mail:<br>
<input type="text" name="mail"><br>
Message:<br>
<input type="text" name="comment" size="50"><br><br>
<input type="submit" value="Send">
<input type="reset" value="Reset">
</form>

<div class="push"></div>
</div>

<footer class="footer">
	<p>No Tech Skill 2018. Updated to NTSC2. Created by Matt Derzay.</p>
</footer>

</body>
</html>