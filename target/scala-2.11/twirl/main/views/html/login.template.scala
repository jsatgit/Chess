
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
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(username: String, password: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.38*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
<head>
	<title>Login</title>
	<script src='"""),_display_(/*8.16*/routes/*8.22*/.Assets.at("javascripts/test.js")),format.raw/*8.55*/("""'></script>
	<script src='"""),_display_(/*9.16*/routes/*9.22*/.Assets.at("javascripts/vendor/knockout.js")),format.raw/*9.66*/("""'></script>
</head>
<body>
	<input type="text" data-bind="text: myName">
	Successfully logged in.	
	Username = """),_display_(/*14.14*/username),format.raw/*14.22*/(""".
	Password = """),_display_(/*15.14*/password),format.raw/*15.22*/(""".
	<p>The name is: <span data-bind="text: myName"></span></p>
	<script>
		function ViewModel() """),format.raw/*18.24*/("""{"""),format.raw/*18.25*/("""  
			"""),format.raw/*19.4*/("""var self = this;  
			self.myName = ko.observable();  
		"""),format.raw/*21.3*/("""}"""),format.raw/*21.4*/("""  

		"""),format.raw/*23.3*/("""ko.applyBindings(new ViewModel());
	</script>
</body>
</html>
"""))}
  }

  def render(username:String,password:String): play.twirl.api.HtmlFormat.Appendable = apply(username,password)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (username,password) => apply(username,password)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Jan 18 23:17:22 EST 2015
                  SOURCE: /Users/jamesshi/Source/chess/app/views/login.scala.html
                  HASH: e01145eda64aa3b5a0e4085713b820fcc27d7632
                  MATRIX: 730->1|854->37|882->39|976->107|990->113|1043->146|1096->173|1110->179|1174->223|1313->335|1342->343|1384->358|1413->366|1536->461|1565->462|1598->468|1682->525|1710->526|1743->532
                  LINES: 26->1|29->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|42->14|42->14|43->15|43->15|46->18|46->18|47->19|49->21|49->21|51->23
                  -- GENERATED --
              */
          