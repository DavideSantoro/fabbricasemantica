/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di login "login"
     * @class
     * @extends quickstart.User
     */
    class Login extends quickstart.User {
        static main(args) {
            let form = quickstart.GestioneElementi.costruisciForm(Login.SERVLET_URL, "5% 45%");
            quickstart.User.addTitleAndInput(form, "Login");
            $(form).append(quickstart.GestionePulsanti.costruisciLogin(), quickstart.GestioneLink.costruisciSignup());
            quickstart.Fabbrica.costruisciPagina(form);
        }
    }
    /**
     * Stringa che rappresenta l'URL della servlet a cui si vogliono inviare i dati
     */
    Login.SERVLET_URL = "login.jsp";
    quickstart.Login = Login;
    Login["__class"] = "quickstart.Login";
})(quickstart || (quickstart = {}));
quickstart.Login.main(null);
