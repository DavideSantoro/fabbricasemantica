/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di login "login"
     * @class
     * @extends quickstart.User
     */
    export class Login extends quickstart.User {
        /**
         * Stringa che rappresenta l'URL della servlet a cui si vogliono inviare i dati
         */
        public static SERVLET_URL : string = "login.jsp";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(Login.SERVLET_URL, "5% 45%");
            User.addTitleAndInput(form, "Login");
            $(form).append(quickstart.GestionePulsanti.costruisciLogin(), quickstart.GestioneLink.costruisciSignup());
            Fabbrica.costruisciPagina(form);
        }
    }
    Login["__class"] = "quickstart.Login";

}


quickstart.Login.main(null);
