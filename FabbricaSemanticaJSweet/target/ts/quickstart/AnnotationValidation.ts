/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe astratta che presenta campi e metodi comuni a tutte le pagine di annotazione/validazione
     * @class
     * @extends quickstart.Fabbrica
     */
    export abstract class AnnotationValidation extends quickstart.Fabbrica {
        /**
         * Stringa che rappresenta l'indirizzo di una delle pagine di annotazione/validazione
         */
        public static RANDOM_URL : string; public static RANDOM_URL_$LI$() : string { if(AnnotationValidation.RANDOM_URL == null) AnnotationValidation.RANDOM_URL = AnnotationValidation.generaURL(); return AnnotationValidation.RANDOM_URL; };

        /**
         * Stringa che rappresenta la servlet a cui vengono inviati i dati una volta fatto il submit della form
         */
        public static REST_URL : string = "nextExample.jsp";

        /**
         * Metodo che serve per aggiungere ai contenitori principali i pulsanti di Next e Skip e i link di Home e Logout
         * @param {HTMLFormElement} form1 primo HTMLFormElement a cui si vogliono aggiungere elementi
         * @param {HTMLFormElement} form2 secondo HTMLFormElement a cui si vogliono aggiungere elementi
         * @param {string} logoutMargin stringa che, una volta associata all'attributo, permette di modificare la posizione del link di logout
         */
        public static addLinksAndButtons(form1 : HTMLFormElement, form2 : HTMLFormElement, logoutMargin : string) {
            $(form1).append(quickstart.GestionePulsanti.costruisciNext(), quickstart.GestioneLink.costruisciHome());
            $(form2).append(quickstart.GestionePulsanti.costruisciSkip(), quickstart.GestioneLink.costruisciLogout(logoutMargin));
            Fabbrica.costruisciPagina(form1, form2);
        }

        /**
         * Metodo che permette di generare un indirizzo casuale
         * @return {string} una stringa che identifica una pagina di annotazione/validazione
         */
        public static generaURL() : string {
            let URL : string = null;
            let i : number = (<number>(Math.random() * 7)|0);
            switch((i)) {
            case 0:
                URL = "definitionAnnotation.html";
                break;
            case 1:
                URL = "myAnnotation.html";
                break;
            case 2:
                URL = "senseAnnotation.html";
                break;
            case 3:
                URL = "senseValidation.html";
                break;
            case 4:
                URL = "translationAnnotation.html";
                break;
            case 5:
                URL = "translationValidation.html";
                break;
            case 6:
                URL = "wordAnnotation.html";
                break;
            }
            return URL;
        }
    }
    AnnotationValidation["__class"] = "quickstart.AnnotationValidation";

}


quickstart.AnnotationValidation.RANDOM_URL_$LI$();
