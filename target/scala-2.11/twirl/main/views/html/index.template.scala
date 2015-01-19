
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>Chess</title>
		<script src='"""),_display_(/*8.17*/routes/*8.23*/.Assets.at("javascripts/vendor/snap.js")),format.raw/*8.63*/("""'></script>
		<script src='"""),_display_(/*9.17*/routes/*9.23*/.Assets.at("javascripts/vendor/knockout.js")),format.raw/*9.67*/("""'></script>
		<link rel="shortcut icon" href="/assets/images/favicon.ico"/>
    </head>
	<body>
		<!-- form action="/login" method="GET">
			<input type="text" name="username" placeholder="Username">
			<input type="password" name="password" placeholder="Password">
			<input type="submit" value="Login">
		</form -->
		<script src='"""),_display_(/*18.17*/routes/*18.23*/.Assets.at("javascripts/chessboard.js")),format.raw/*18.62*/("""'></script>
    </body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 18 23:17:22 EST 2015
                  SOURCE: /Users/jamesshi/Source/chess/app/views/index.scala.html
                  HASH: 89c9c5567c463265dd38fb2a2505c56432926885
                  MATRIX: 716->1|805->3|833->5|939->85|953->91|1013->131|1067->159|1081->165|1145->209|1506->543|1521->549|1581->588
                  LINES: 26->1|29->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|46->18|46->18|46->18
                  -- GENERATED --
              */
          