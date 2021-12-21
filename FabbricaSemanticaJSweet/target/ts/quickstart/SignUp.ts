/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di registrazione "signup"
     * @class
     * @extends quickstart.User
     */
    export class Signup extends quickstart.User {
        /**
         * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
         */
        public static SERVLET_URL : string = "signup.jsp";

        public static main(args : string[]) {
            let form : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(Signup.SERVLET_URL, "5% 45%");
            let label : HTMLLabelElement = quickstart.GestioneElementi.costruisciEtichetta("Lingue Parlate");
            let labelIta : HTMLLabelElement = quickstart.GestioneElementi.costruisciEtichetta("Italiano");
            let labelEng : HTMLLabelElement = quickstart.GestioneElementi.costruisciEtichetta("Inglese");
            $(labelIta).css("background-color", "#ffffff");
            $(labelEng).css("background-color", "#ffffff");
            User.addTitleAndInput(form, "Registrazione");
            $(form).append(quickstart.GestioneElementi.costruisciPassword("Ripeti Password"), quickstart.GestioneElementi.divEtichetta(label), quickstart.GestioneElementi.divCheckbox(quickstart.GestioneElementi.costruisciCheckbox("checkboxItaliano", "15px", "15px"), labelIta), quickstart.GestioneElementi.divCheckbox(quickstart.GestioneElementi.costruisciCheckbox("checkboxInglese", "15px", "15px"), labelEng), quickstart.GestioneElementi.costruisciEtichetta("Altre Lingue Parlate (Opzionale)"), quickstart.GestioneElementi.costruisciSelect("altraLingua1"), quickstart.GestioneElementi.costruisciSelect("altraLingua2"), quickstart.GestionePulsanti.costruisciSignup(), quickstart.GestioneLink.costruisciLogin());
            Fabbrica.costruisciPagina(form);
        }
    }
    Signup["__class"] = "quickstart.Signup";

}


quickstart.Signup.main(null);
