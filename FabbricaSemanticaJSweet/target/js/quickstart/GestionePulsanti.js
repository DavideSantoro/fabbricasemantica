/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che disponde di metodi statici utili alla configurazione e alla costruzione
     * dei pulsanti propri di una o pi� pagine HTML
     * @class
     */
    class GestionePulsanti {
        /**
         * Metodo che permette la costruzione del pulsante per fare il login
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement login configurato
         */
        static costruisciLogin() {
            let login = document.createElement("input");
            login.type = "submit";
            login.name = "login_button";
            login.className = "btn btn-primary";
            login.value = "Login";
            $(login).css("margin", "4% 48%");
            let divLogin = document.createElement("div");
            divLogin.className = "form-group";
            $(divLogin).append(login);
            return divLogin;
        }
        /**
         * Metodo che permette la costruzione del pulsante per fare il signup
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement signup configurato
         */
        static costruisciSignup() {
            let signup = document.createElement("input");
            signup.type = "submit";
            signup.name = "signup_button";
            signup.className = "btn btn-primary";
            signup.value = "Sign Up";
            $(signup).css("margin", "4% 48%");
            let divSignup = document.createElement("div");
            divSignup.className = "form-group";
            $(divSignup).append(signup);
            return divSignup;
        }
        /**
         * Metodo che permette la costruzione del pulsante grazie al quale si possono iniziare a svolgere
         * i task di annotazione/validazione
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement start configurato
         */
        static costruisciStart() {
            let start = document.createElement("input");
            start.type = "image";
            start.name = "start_button";
            start.className = "btn btn-primary";
            start.src = "http://i.imgur.com/1SEMAUq.png";
            $(start).css("width", "200px").css("height", "200px");
            let divStart = document.createElement("div");
            divStart.className = "form-group";
            $(divStart).append(start);
            return divStart;
        }
        /**
         * Metodo che permette la costruzione del pulsante attraverso cui si salvano le informazioni
         * che l'utente ha inserito all'interno del task e si indirizza l'utente ad una pagina a caso
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement next configurato
         */
        static costruisciNext() {
            let next = document.createElement("input");
            next.type = "submit";
            next.name = "next_button";
            next.className = "btn btn-primary";
            next.value = "Next";
            let divNext = document.createElement("div");
            divNext.className = "form-group";
            $(divNext).append(next);
            return divNext;
        }
        /**
         * Metodo che permette la costruzione del pulsante attraverso cui l'utente viene indirizzato l'utente
         * ad una pagina a caso senza salvare le informazioni che sono state inserite
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement skip configurato
         */
        static costruisciSkip() {
            let skip = document.createElement("input");
            skip.type = "submit";
            skip.name = "skip_button";
            skip.className = "btn btn-primary";
            skip.value = "Skip";
            let divSkip = document.createElement("div");
            divSkip.className = "form-group";
            $(divSkip).append(skip);
            return divSkip;
        }
        /**
         * Metodo che permette la costruzione del pulsante di tipo radio
         * @param {string} valore stringa che rappresenta il valore del pulsante e il testo dell'etichetta ad esso associata
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement di tipo radio configurato
         */
        static costruisciRadio(valore) {
            let radio = document.createElement("input");
            radio.name = "radio";
            radio.type = "radio";
            radio.value = valore;
            let divRadio = document.createElement("div");
            divRadio.className = "form-group";
            $(divRadio).append(radio, quickstart.GestioneElementi.costruisciEtichetta(valore));
            return divRadio;
        }
        /**
         * Metodo che permette la costruzione del pulsante con cui � possibile svolgere da capo
         * il task "myAnnotation"
         * @param {Array} divLettere array di HTMLDivElement che contiene i riferimenti agli elementi trascinabili
         * @param {Array} divDestinazioni array di HTMLDivElement che contiene i riferimenti agli elementi che possono accettare il rilascio
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement restart configurato
         */
        static costruisciRestart(divLettere, divDestinazioni) {
            let restart = document.createElement("input");
            restart.type = "button";
            restart.name = "restart_button";
            restart.className = "btn btn-primary";
            restart.value = "Restart";
            restart.addEventListener("click", (event) => {
                for (let i = 0; i < divLettere.length; i++) {
                    {
                        $(divLettere[i]).attr("draggable", "true");
                        $(divLettere[i]).css("border-style", "solid");
                    }
                    ;
                }
                for (let j = 0; j < divDestinazioni.length; j++) {
                    {
                        $(divDestinazioni[j]).css("border-style", "dashed");
                        $(divDestinazioni[j]).text("_");
                    }
                    ;
                }
                return null;
            });
            let divRestart = document.createElement("div");
            $(divRestart).append(restart);
            return divRestart;
        }
    }
    quickstart.GestionePulsanti = GestionePulsanti;
    GestionePulsanti["__class"] = "quickstart.GestionePulsanti";
})(quickstart || (quickstart = {}));
