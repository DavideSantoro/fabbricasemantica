/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della homepage del progetto FabbricaSemantica "home.html"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    class Home extends quickstart.AnnotationValidation {
        static main(args) {
            let form = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "5% 45%");
            $.getJSON(Home.SERVLET_URL, (result, a, ctx) => {
                let json = result;
                let isLoggedIn = (json["isLoggedIn"]);
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })(isLoggedIn, "false"))
                    window.location.href = Home.LOGIN_URL;
                return null;
            });
            $(form).append(quickstart.GestioneElementi.costruisciTitolo("Home"), quickstart.GestionePulsanti.costruisciStart(), quickstart.GestioneLink.costruisciLogout("5% 100%"));
            quickstart.Fabbrica.costruisciPagina(form);
        }
    }
    /**
     * Stringa che rappresenta l'URL della pagina di login
     */
    Home.LOGIN_URL = "login.html";
    /**
     * Stringa che rappresenta l'URL della servlet che serve per verificare se l'utente � loggato
     */
    Home.SERVLET_URL = "isLoggedIn.jsp";
    quickstart.Home = Home;
    Home["__class"] = "quickstart.Home";
})(quickstart || (quickstart = {}));
quickstart.Home.main(null);
