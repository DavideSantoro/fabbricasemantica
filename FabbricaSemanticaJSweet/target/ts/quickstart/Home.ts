/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della homepage del progetto FabbricaSemantica "home.html"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    export class Home extends quickstart.AnnotationValidation {
        /**
         * Stringa che rappresenta l'URL della pagina di login
         */
        public static LOGIN_URL : string = "login.html";

        /**
         * Stringa che rappresenta l'URL della servlet che serve per verificare se l'utente è loggato
         */
        public static SERVLET_URL : string = "isLoggedIn.jsp";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "5% 45%");
            $.getJSON(Home.SERVLET_URL, (result, a, ctx) => {
                let json : JSON = <JSON>result;
                let isLoggedIn : string = <any>(json["isLoggedIn"]);
                if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(isLoggedIn,"false"))) window.location.href = Home.LOGIN_URL;
                return null;
            });
            $(form).append(quickstart.GestioneElementi.costruisciTitolo("Home"), quickstart.GestionePulsanti.costruisciStart(), quickstart.GestioneLink.costruisciLogout("5% 100%"));
            Fabbrica.costruisciPagina(form);
        }
    }
    Home["__class"] = "quickstart.Home";

}


quickstart.Home.main(null);
