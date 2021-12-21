/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe astratta con un metodo che svolge le medesime funzioni per entrambe le pagine
     * di gestione dell'utente
     * @class
     * @extends quickstart.Fabbrica
     */
    class User extends quickstart.Fabbrica {
        /**
         * Metodo che serve per aggiungere al contenitore principale il titolo, l'email e la password
         * @param {HTMLFormElement} form HTMLFormElement a cui si vogliono aggiungere gli elementi
         * @param {string} titolo stringa che rappresenta il titolo della pagina
         */
        static addTitleAndInput(form, titolo) {
            $(form).append(quickstart.GestioneElementi.costruisciTitolo(titolo), quickstart.GestioneElementi.costruisciEmail(), quickstart.GestioneElementi.costruisciPassword("Password"));
        }
    }
    quickstart.User = User;
    User["__class"] = "quickstart.User";
})(quickstart || (quickstart = {}));
