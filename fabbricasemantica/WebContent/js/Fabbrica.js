/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe astratta che presenta metodi comuni sia alle pagine di annotazione/validazione
     * che alle pagine che servono per la gestione dell'utente
     * @class
     */
    class Fabbrica {
        static costruisciPagina(form1, form2 = null) {
            $("body").append(form1, form2).css("background-color", "#00ffff");
        }
    }
    quickstart.Fabbrica = Fabbrica;
    Fabbrica["__class"] = "quickstart.Fabbrica";
})(quickstart || (quickstart = {}));
