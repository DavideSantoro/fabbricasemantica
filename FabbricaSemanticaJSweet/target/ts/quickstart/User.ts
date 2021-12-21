/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe astratta con un metodo che svolge le medesime funzioni per entrambe le pagine
     * di gestione dell'utente
     * @class
     * @extends quickstart.Fabbrica
     */
    export abstract class User extends quickstart.Fabbrica {
        /**
         * Metodo che serve per aggiungere al contenitore principale il titolo, l'email e la password
         * @param {HTMLFormElement} form HTMLFormElement a cui si vogliono aggiungere gli elementi
         * @param {string} titolo stringa che rappresenta il titolo della pagina
         */
        public static addTitleAndInput(form : HTMLFormElement, titolo : string) {
            $(form).append(quickstart.GestioneElementi.costruisciTitolo(titolo), quickstart.GestioneElementi.costruisciEmail(), quickstart.GestioneElementi.costruisciPassword("Password"));
        }
    }
    User["__class"] = "quickstart.User";

}

