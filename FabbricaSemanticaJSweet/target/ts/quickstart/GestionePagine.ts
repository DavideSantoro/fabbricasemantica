/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe utile a modularizzare la creazione delle pagine
     * @class
     */
    export class GestionePagine {
        /**
         * Metodo che costruisce il titolo della pagina in questione
         * @param {string} titolo
         * @return {HTMLDivElement}
         */
        public static costruisciTitolo(titolo : string) : HTMLDivElement {
            let title : HTMLLabelElement = document.createElement("label");
            title.className = "form-control-plaintext";
            let divTitle : HTMLDivElement = document.createElement("div");
            divTitle.className = "form-group";
            let labelT : HTMLLabelElement = document.createElement("label");
            labelT.textContent = titolo;
            $(labelT).css("font-weight", "bold");
            $(labelT).css("font-size", "23px");
            $(divTitle).append(labelT);
            $(divTitle).append(title);
            return divTitle;
        }

        public static costruisciEmail() : HTMLDivElement {
            let emailAddress : HTMLInputElement = document.createElement("input");
            emailAddress.type = "email";
            emailAddress.name = "email";
            let divEmailAddress : HTMLDivElement = document.createElement("div");
            divEmailAddress.className = "form-group";
            let label : HTMLLabelElement = document.createElement("label");
            label.textContent = "Email";
            $(divEmailAddress).append(label);
            $(divEmailAddress).append(emailAddress);
            return divEmailAddress;
        }

        public static costruisciPassword(contenuto : string) : HTMLDivElement {
            let password : HTMLInputElement = document.createElement("input");
            password.type = "password";
            password.name = "password";
            let divPassword : HTMLDivElement = document.createElement("div");
            divPassword.className = "form-group";
            let labelP : HTMLLabelElement = document.createElement("label");
            labelP.textContent = contenuto;
            $(divPassword).append(labelP);
            $(divPassword).append(password);
            return divPassword;
        }
    }
    GestionePagine["__class"] = "quickstart.GestionePagine";

}

