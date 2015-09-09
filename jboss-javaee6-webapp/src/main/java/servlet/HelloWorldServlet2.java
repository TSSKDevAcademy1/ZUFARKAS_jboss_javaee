package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello2")
public class HelloWorldServlet2 extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// String nname = request.getParameter("meno");
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");

		// request.getParameter("meno"));
		if (isValidName(request.getParameter("meno")) & isValidPassword(request.getParameter("heslo"))
				& isValidAge(request.getParameter("age"))) {
			out.printf("<h1>Hello  %s from %s, you are %s years old!</h1>", request.getParameter("meno"),
					request.getParameter("country"), request.getParameter("age"));

			// request.getParameter("name");
		}

		request.setAttribute("name", "");
		out.printf("<img src=\"resources/gfx/wildfly_400x130.jpg\" />");

		/**
		 * The action attribute specifies where to send the form-data when a
		 * form is submitted.
		 */
		out.println("<form action =\"hello2\" method = \"post\">");

		out.println("Name: <input type=\"text\" name = \"meno\">");
		if (!isValidName(request.getParameter("meno"))) {
			out.println("wrong name format");
		}

		out.println("<br>");

		out.println("Password: <input type=\"password\" name = \"heslo\">");
		if (!isValidPassword(request.getParameter("heslo"))) {
			out.println("wrong password format");
		}

		out.println("<br>");

		out.println("Age: <input type=\"number\" name = \"age\">");
		if (!isValidAge(request.getParameter("age"))) {
			out.println("wrong age");
		}
		out.println("<br>");

		//////////////////////
		out.print("Country: ");
		out.println("<select name = \"country\">");
		out.println("<option value=\"  \">---Select---</option>");
		out.println("<option value=\"AF\">Afghanistan</option>");
		out.println("<option value=\"AL\">Albania</option>");
		out.println("<option value=\"DZ\">Algeria</option>");
		out.println("<option value=\"AS\">American Samoa</option>");
		out.println("<option value=\"AD\">Andorra</option>");
		out.println("<option value=\"AG\">Angola</option>");
		out.println("<option value=\"AI\">Anguilla</option>");
		out.println("<option value=\"AG\">Antigua &amp; Barbuda</option>");
		out.println("<option value=\"AR\">Argentina</option>");
		out.println("<option value=\"AA\">Armenia</option>");
		out.println("<option value=\"AW\">Aruba</option>");
		out.println("<option value=\"AU\">Australia</option>");
		out.println("<option value=\"AT\">Austria</option>");
		out.println("<option value=\"AZ\">Azerbaijan</option>");
		out.println("<option value=\"BS\">Bahamas</option>");
		out.println("<option value=\"BH\">Bahrain</option>");
		out.println("<option value=\"BD\">Bangladesh</option>");
		out.println("<option value=\"BB\">Barbados</option>");
		out.println("<option value=\"BY\">Belarus</option>");
		out.println("<option value=\"BE\">Belgium</option>");
		out.println("<option value=\"BZ\">Belize</option>");
		out.println("<option value=\"BJ\">Benin</option>");
		out.println("<option value=\"BM\">Bermuda</option>");
		out.println("<option value=\"BT\">Bhutan</option>");
		out.println("<option value=\"BO\">Bolivia</option>");
		out.println("<option value=\"BL\">Bonaire</option>");
		out.println("<option value=\"BA\">Bosnia &amp; Herzegovina</option>");
		out.println("<option value=\"BW\">Botswana</option>");
		out.println("<option value=\"BR\">Brazil</option>");
		out.println("<option value=\"BC\">British Indian Ocean Ter</option>");
		out.println("<option value=\"BN\">Brunei</option>");
		out.println("<option value=\"BG\">Bulgaria</option>");
		out.println("<option value=\"BF\">Burkina Faso</option>");
		out.println("<option value=\"BI\">Burundi</option>");
		out.println("<option value=\"KH\">Cambodia</option>");
		out.println("<option value=\"CM\">Cameroon</option>");
		out.println("<option value=\"CA\">Canada</option>");
		out.println("<option value=\"IC\">Canary Islands</option>");
		out.println("<option value=\"CV\">Cape Verde</option>");
		out.println("<option value=\"KY\">Cayman Islands</option>");
		out.println(" <option value=\"CF\">Central African Republic</option>");
		out.println("<option value=\"TD\">Chad</option>");
		out.println("<option value=\"CD\">Channel Islands</option>");
		out.println("<option value=\"CL\">Chile</option>");
		out.println("<option value=\"CN\">China</option>");
		out.println("<option value=\"CI\">Christmas Island</option>");
		out.println("<option value=\"CS\">Cocos Island</option>");
		out.println("<option value=\"CO\">Colombia</option>");
		out.println("<option value=\"CC\">Comoros</option>");
		out.println("<option value=\"CG\">Congo</option>");
		out.println("<option value=\"CK\">Cook Islands</option>");
		out.println("<option value=\"CR\">Costa Rica</option>");
		out.println("<option value=\"CT\">Cote D\'Ivoire</option>");
		out.println("<option value=\"HR\">Croatia</option>");
		out.println("<option value=\"CU\">Cuba</option>");
		out.println("<option value=\"CB\">Curacao</option>");
		out.println("<option value=\"CY\">Cyprus</option>");
		out.println("<option value=\"CZ\">Czech Republic</option>");
		out.println("<option value=\"DK\">Denmark</option>");
		out.println("<option value=\"DJ\">Djibouti</option>");
		out.println("<option value=\"DM\">Dominica</option>");
		out.println("<option value=\"DO\">Dominican Republic</option>");
		out.println("<option value=\"TM\">East Timor</option>");
		out.println("<option value=\"EC\">Ecuador</option>");
		out.println("<option value=\"EG\">Egypt</option>");
		out.println("<option value=\"SV\">El Salvador</option>");
		out.println("<option value=\"GQ\">Equatorial Guinea</option>");
		out.println("<option value=\"ER\">Eritrea</option>");
		out.println("<option value=\"EE\">Estonia</option>");
		out.println("<option value=\"ET\">Ethiopia</option>");
		out.println("<option value=\"FA\">Falkland Islands</option>");
		out.println("<option value=\"FO\">Faroe Islands</option>");
		out.println("<option value=\"FJ\">Fiji</option>");
		out.println("<option value=\"FI\">Finland</option>");
		out.println("<option value=\"FR\">France</option>");
		out.println("<option value=\"GF\">French Guiana</option>");
		out.println("<option value=\"PF\">French Polynesia</option>");
		out.println("<option value=\"FS\">French Southern Ter</option>");
		out.println("<option value=\"GA\">Gabon</option>");
		out.println("<option value=\"GM\">Gambia</option>");
		out.println("<option value=\"GE\">Georgia</option>");
		out.println("<option value=\"DE\">Germany</option>");
		out.println("<option value=\"GH\">Ghana</option>");
		out.println("<option value=\"GI\">Gibraltar</option>");
		// <option value=\"GB">Great Britain</option>
		// <option value=\"GR">Greece</option>
		// <option value=\"GL">Greenland</option>
		// <option value=\"GD">Grenada</option>
		// <option value=\"GP">Guadeloupe</option>
		// <option value=\"GU">Guam</option>
		// <option value=\"GT">Guatemala</option>
		// <option value=\"GN">Guinea</option>
		// <option value=\"GY">Guyana</option>
		// <option value=\"HT">Haiti</option>
		// <option value=\"HW">Hawaii</option>
		// <option value=\"HN">Honduras</option>
		// <option value=\"HK">Hong Kong</option>
		// <option value=\"HU">Hungary</option>
		// <option value=\"IS">Iceland</option>
		// <option value=\"IN">India</option>
		// <option value=\"ID">Indonesia</option>
		// <option value=\"IA">Iran</option>
		// <option value=\"IQ">Iraq</option>
		// <option value=\"IR">Ireland</option>
		// <option value=\"IM">Isle of Man</option>
		// <option value=\"IL">Israel</option>
		// <option value=\"IT">Italy</option>
		// <option value=\"JM">Jamaica</option>
		// <option value=\"JP">Japan</option>
		// <option value=\"JO">Jordan</option>
		// <option value=\"KZ\">Kazakhstan</option>
		// <option value=\"KE\">Kenya</option>
		// <option value=\"KI\">Kiribati</option>
		// <option value=\"NK\">Korea North</option>
		// <option value=\"KS\">Korea South</option>
		// <option value=\"KW\">Kuwait</option>
		// <option value=\"KG\">Kyrgyzstan</option>
		// <option value=\"LA\">Laos</option>
		// <option value=\"LV\">Latvia</option>
		// <option value="LB">Lebanon</option>
		// <option value="LS">Lesotho</option>
		// <option value="LR">Liberia</option>
		// <option value="LY">Libya</option>
		// <option value="LI">Liechtenstein</option>
		// <option value="LT">Lithuania</option>
		// <option value="LU">Luxembourg</option>
		// <option value="MO">Macau</option>
		// <option value="MK">Macedonia</option>
		// <option value="MG">Madagascar</option>
		// <option value="MY">Malaysia</option>
		// <option value="MW">Malawi</option>
		// <option value="MV">Maldives</option>
		// <option value="ML">Mali</option>
		// <option value="MT">Malta</option>
		// <option value="MH">Marshall Islands</option>
		// <option value="MQ">Martinique</option>
		// <option value="MR">Mauritania</option>
		// <option value="MU">Mauritius</option>
		// <option value="ME">Mayotte</option>
		// <option value="MX">Mexico</option>
		// <option value="MI">Midway Islands</option>
		// <option value="MD">Moldova</option>
		// <option value="MC">Monaco</option>
		// <option value="MN">Mongolia</option>
		// <option value="MS">Montserrat</option>
		// <option value="MA">Morocco</option>
		// <option value="MZ">Mozambique</option>
		// <option value="MM">Myanmar</option>
		// <option value="NA">Nambia</option>
		// <option value="NU">Nauru</option>
		// <option value="NP">Nepal</option>
		// <option value="AN">Netherland Antilles</option>
		// <option value="NL">Netherlands (Holland, Europe)</option>
		// <option value="NV">Nevis</option>
		// <option value="NC">New Caledonia</option>
		// <option value="NZ">New Zealand</option>
		// <option value="NI">Nicaragua</option>
		// <option value="NE">Niger</option>
		// <option value="NG">Nigeria</option>
		// <option value="NW">Niue</option>
		// <option value="NF">Norfolk Island</option>
		// <option value="NO">Norway</option>
		// <option value="OM">Oman</option>
		// <option value="PK">Pakistan</option>
		// <option value="PW">Palau Island</option>
		// <option value="PS">Palestine</option>
		// <option value="PA">Panama</option>
		// <option value="PG">Papua New Guinea</option>
		// <option value="PY">Paraguay</option>
		// <option value="PE">Peru</option>
		// <option value="PH">Philippines</option>
		// <option value="PO">Pitcairn Island</option>
		// <option value="PL">Poland</option>
		// <option value="PT">Portugal</option>
		// <option value="PR">Puerto Rico</option>
		// <option value="QA">Qatar</option>
		// <option value="ME">Republic of Montenegro</option>
		// <option value="RS">Republic of Serbia</option>
		// <option value="RE">Reunion</option>
		// <option value="RO">Romania</option>
		// <option value="RU">Russia</option>
		// <option value="RW">Rwanda</option>
		// <option value="NT">St Barthelemy</option>
		// <option value="EU">St Eustatius</option>
		// <option value="HE">St Helena</option>
		// <option value="KN">St Kitts-Nevis</option>
		// <option value="LC">St Lucia</option>
		// <option value="MB">St Maarten</option>
		// <option value="PM">St Pierre &amp; Miquelon</option>
		// <option value="VC">St Vincent &amp; Grenadines</option>
		// <option value="SP">Saipan</option>
		// <option value="SO">Samoa</option>
		// <option value="AS">Samoa American</option>
		// <option value="SM">San Marino</option>
		// <option value="ST">Sao Tome &amp; Principe</option>
		// <option value="SA">Saudi Arabia</option>
		// <option value="SN">Senegal</option>
		// <option value="RS">Serbia</option>
		// <option value="SC">Seychelles</option>
		// <option value="SL">Sierra Leone</option>
		// <option value="SG">Singapore</option>
		// <option value="SK">Slovakia</option>
		// <option value="SI">Slovenia</option>
		// <option value="SB">Solomon Islands</option>
		// <option value="OI">Somalia</option>
		// <option value="ZA">South Africa</option>
		// <option value="ES">Spain</option>
		// <option value="LK">Sri Lanka</option>
		// <option value="SD">Sudan</option>
		// <option value="SR">Suriname</option>
		// <option value="SZ">Swaziland</option>
		// <option value="SE">Sweden</option>
		// <option value="CH">Switzerland</option>
		// <option value="SY">Syria</option>
		// <option value="TA">Tahiti</option>
		// <option value="TW">Taiwan</option>
		// <option value="TJ">Tajikistan</option>
		// <option value="TZ">Tanzania</option>
		// <option value="TH">Thailand</option>
		// <option value="TG">Togo</option>
		// <option value="TK">Tokelau</option>
		// <option value="TO">Tonga</option>
		// <option value="TT">Trinidad &amp; Tobago</option>
		// <option value="TN">Tunisia</option>
		// <option value="TR">Turkey</option>
		// <option value="TU">Turkmenistan</option>
		// <option value="TC">Turks &amp; Caicos Is</option>
		// <option value="TV">Tuvalu</option>
		// <option value="UG">Uganda</option>
		// <option value="UA">Ukraine</option>
		// <option value="AE">United Arab Emirates</option>
		// <option value="GB">United Kingdom</option>
		// <option value="US">United States of America</option>
		// <option value="UY">Uruguay</option>
		// <option value="UZ">Uzbekistan</option>
		// <option value="VU">Vanuatu</option>
		// <option value="VS">Vatican City State</option>
		// <option value="VE">Venezuela</option>
		// <option value="VN">Vietnam</option>
		// <option value="VB">Virgin Islands (Brit)</option>
		// <option value="VA">Virgin Islands (USA)</option>
		// <option value="WK">Wake Island</option>
		// <option value="WF">Wallis &amp; Futana Is</option>
		// <option value="YE">Yemen</option>
		// <option value="ZR">Zaire</option>
		// <option value="ZM">Zambia</option>
		// <option value="ZW">Zimbabwe</option>

		out.println("</select>");

		out.println("<br>");

		///////////////////////////////////////
		out.println(" <input type=\"submit\" value = \"Send!\">");

		// request.getParameter("meno")

		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doGet(req, resp);
	}

	private boolean isValidName(String s) {

		if (s == null || s.equals("") || s.length() > 10 || s.length() < 5) {
			return false;
		}

		return true;
	}

	private boolean isValidPassword(String s) {

		if (s == null || s.equals("") || s.length() > 10 || s.length() < 5) {
			return false;
		}
		int len = s.length();
		for (int i = 0; i < len; i++) {

			if (Character.isDigit(s.charAt(i))) {
				return true;
			}
		}

		return false;
	}

	private boolean isValidAge(String ages) {
		try {
			int age = Integer.parseInt(ages);
			return age > 0 & age < 151;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
