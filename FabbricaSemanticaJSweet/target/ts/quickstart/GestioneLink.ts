/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che dispone di metodi statici utili alla configurazione e alla costruzione
     * dei redirect propri di una o più pagine HTML
     * @class
     */
    export class GestioneLink {
        /**
         * Metodo che permette la costruzione del link che serve per tornare alla homepage di FabbricaSemantica
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HMLAnchorElement home configurato
         */
        public static costruisciHome() : HTMLDivElement {
            let home : HTMLAnchorElement = document.createElement("a");
            home.href = "home.html";
            home.name = "link_home";
            home.text = "Torna alla home";
            $(home).css("white-space", "nowrap");
            let divHome : HTMLDivElement = document.createElement("div");
            divHome.className = "form-group";
            $(divHome).append(home);
            return divHome;
        }

        /**
         * Metodo che permette la costruzione del link che serve per indirizzare alla pagina di login
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLAnchorElement login configurato
         */
        public static costruisciLogin() : HTMLDivElement {
            let login : HTMLAnchorElement = document.createElement("a");
            login.href = "login.html";
            login.name = "link_login";
            login.text = "Hai gi\u00e0 un account? Accedi!";
            let divLogin : HTMLDivElement = document.createElement("div");
            divLogin.className = "form-group";
            $(divLogin).append(login);
            return divLogin;
        }

        /**
         * Metodo che permette la costruzione del link che serve per indirizzare alla pagina di signup
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLAnchorElement signup configurato
         */
        public static costruisciSignup() : HTMLDivElement {
            let signup : HTMLAnchorElement = document.createElement("a");
            signup.href = "signup.html";
            signup.name = "link_signup";
            signup.text = "Non hai un account? Registrati ora!";
            let divSignup : HTMLDivElement = document.createElement("div");
            divSignup.className = "form-group";
            $(divSignup).append(signup);
            return divSignup;
        }

        /**
         * Metodo che permette la costruzione del link che serve per effettuare il logout
         * @param {string} margine stringa associata all'attributo che consente di cambiare il posizionamento del link all'interno della pagina
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLAnchorElement logout configurato
         */
        public static costruisciLogout(margine : string) : HTMLDivElement {
            let logout : HTMLAnchorElement = document.createElement("a");
            logout.href = "logout.jsp";
            logout.name = "link_logout";
            logout.text = "Logout";
            $(logout).css("margin", margine);
            let divLogout : HTMLDivElement = document.createElement("div");
            divLogout.className = "form-group";
            $(divLogout).append(logout);
            return divLogout;
        }
    }
    GestioneLink["__class"] = "quickstart.GestioneLink";

}

