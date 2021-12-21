/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe astratta che presenta metodi comuni sia alle pagine di annotazione/validazione
     * che alle pagine che servono per la gestione dell'utente
     * @class
     */
    export abstract class Fabbrica {
        public static costruisciPagina(form1 : HTMLFormElement, form2 : HTMLFormElement = null) {
            $("body").append(form1, form2).css("background-color", "#00ffff");
        }
    }
    Fabbrica["__class"] = "quickstart.Fabbrica";

}

