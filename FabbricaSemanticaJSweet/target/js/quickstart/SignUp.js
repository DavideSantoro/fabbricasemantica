/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di registrazione "signup"
     * @class
     * @extends quickstart.User
     */
    class Signup extends quickstart.User {
        static main(args) {
            let form = quickstart.GestioneElementi.costruisciForm(Signup.SERVLET_URL, "5% 45%");
            let label = quickstart.GestioneElementi.costruisciEtichetta("Lingue Parlate");
            let labelIta = quickstart.GestioneElementi.costruisciEtichetta("Italiano");
            let labelEng = quickstart.GestioneElementi.costruisciEtichetta("Inglese");
            $(labelIta).css("background-color", "#ffffff");
            $(labelEng).css("background-color", "#ffffff");
            quickstart.User.addTitleAndInput(form, "Registrazione");
            $(form).append(quickstart.GestioneElementi.costruisciPassword("Ripeti Password"), quickstart.GestioneElementi.divEtichetta(label), quickstart.GestioneElementi.divCheckbox(quickstart.GestioneElementi.costruisciCheckbox("checkboxItaliano", "15px", "15px"), labelIta), quickstart.GestioneElementi.divCheckbox(quickstart.GestioneElementi.costruisciCheckbox("checkboxInglese", "15px", "15px"), labelEng), quickstart.GestioneElementi.costruisciEtichetta("Altre Lingue Parlate (Opzionale)"), quickstart.GestioneElementi.costruisciSelect("altraLingua1"), quickstart.GestioneElementi.costruisciSelect("altraLingua2"), quickstart.GestionePulsanti.costruisciSignup(), quickstart.GestioneLink.costruisciLogin());
            quickstart.Fabbrica.costruisciPagina(form);
        }
    }
    /**
     * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
     */
    Signup.SERVLET_URL = "signup.jsp";
    quickstart.Signup = Signup;
    Signup["__class"] = "quickstart.Signup";
})(quickstart || (quickstart = {}));
quickstart.Signup.main(null);
