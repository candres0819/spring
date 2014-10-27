<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Menú</title>
	<link type="text/css" href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
	<link type="text/css" href="<c:url value='/resources/css/tabmenu.css'/>" rel="stylesheet"/>
</head>
<body>
	<header>
		<div>Usuario: ${usuario.nombre}</div>
		<ul id="tabmenu">
			<li>
				<span>Tab Menu</span>
				<ul>
					<li>
						<a href="?11">Sub menu 1</a>
						<ul>
							<li><a href="?111">Tab menu 1-1-1</a></li>
							<li><a href="?112">Tab menu 1-1-2</a></li>
							<li><a href="?113">Tab menu 1-1-3</a></li>
							<li><a href="?114">Tab menu 1-1-4</a></li>
						</ul>
					</li>
					<li>
						<a href="?12">Sub menu 2</a>
						<ul>
							<li><a href="?121">Tab menu 1-2-1</a></li>
							<li><a href="?122">Tab menu 1-2-2</a></li>
						</ul>
					</li>
					<li><a href="?13">Sub menu 3</a></li>
				</ul>
			</li>
			<li>
				<a href="?2">Tabbed Menu</a>
				<ul>
					<li>
						<a href="?21">Horizontal submenu 1</a>
						<ul>
							<li><a href="?211">Tabbed menu 2-1-1</a></li>
							<li><a href="?212">Tabbed menu 2-1-2</a></li>
						</ul>
					</li>
					<li>
						<a href="?22">Horizontal submenu 2</a>
						<ul>
							<li><a href="?221">Tabbed menu 2-2-1</a></li>
							<li><a href="?222">Tabbed menu 2-2-2</a></li>
							<li><a href="?223">Tabbed menu 2-2-3</a></li>
							<li><a href="?224">Tabbed menu 2-2-4</a></li>
						</ul>
					</li>
					<li><a href="?23">Horizontal submenu 3</a></li>
				</ul>
			</li>
			<li>
				<a href="?3">Delivery</a>
				<ul>
					<li><a href="?31">Tab menu 3-1</a></li>
					<li><a href="?32">Tab menu 3-2</a></li>
				</ul>
			</li>
			<li><a href="?4">Contact Us</a></li>
		</ul>
	</header>
	<section>
		<div style="margin:60px auto; width:500px; font: 0.8em Arial; color:#666;">
			<ul>
				<li>
					By default, the menu item that best matches the current page URL will be selected when the menu is loaded. You can also use the built-in
					<a href="http://www.menucool.com/horizontal/tab-menu#view5" target="_blank">select</a> function to select a desired tab.
					It is especially useful when the current page URL is not included in the menu, but you still want a specific tab to be selected.<br />&nbsp;
				</li>
				<li>
					If you do not want to cut and paste the menu HTML code on every page, you can store your website menu in a separate file, and just reference the file on every page.
					Visit <a href="http://www.menucool.com/horizontal/tab/keep-menu-source-in-one-place" target="_blank">Keep menu source in one place</a> for details.
				</li>
			</ul>
		</div>
	</section>
	<footer>
	
	</footer>
</body>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/tabmenu.js'/>"></script>
</html>