/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che dispone di metodi statici utili alla configurazione e alla costruzione
     * degli elementi che compongono la struttura delle pagine HTML
     * @class
     */
    class GestioneElementi {
        /**
         * Metodo che serve per la costruzione di una form
         * @param {string} servlet stringa corrispondente all'URL a cui va inviato il messaggio per fare il submit
         * @param {string} margine stringa associata all'attributo che permette di modificare la posizione della form all'interno della pagina
         * @return {HTMLFormElement} un HTMLFormElement che rappresenta il contenitore principale
         */
        static costruisciForm(servlet, margine) {
            let form = document.createElement("form");
            form.action = servlet;
            form.method = "POST";
            $(form).css("margin", margine);
            return form;
        }
        /**
         * Metodo che serve a costruire il titolo di una pagina HTML
         * @param {string} titolo stringa corrispondente al titolo della pagina
         * @return {HTMLDivElement} un HTMLDivElement che contiene un HTMLLabelElement con il testo uguale al titolo
         */
        static costruisciTitolo(titolo) {
            let labelTitle = GestioneElementi.costruisciEtichetta(titolo);
            $(labelTitle).css("font-weight", "bold").css("font-size", "23px");
            return GestioneElementi.divEtichetta(labelTitle);
        }
        /**
         * Metodo che serve a costruire lo spazio di testo in cui l'utente pu� inserire la sua email
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement email
         */
        static costruisciEmail() {
            let emailAddress = document.createElement("input");
            emailAddress.type = "email";
            emailAddress.name = "email";
            let divEmailAddress = document.createElement("div");
            divEmailAddress.className = "form-group";
            $(divEmailAddress).append(GestioneElementi.costruisciEtichetta("Email"), emailAddress);
            return divEmailAddress;
        }
        /**
         * Metodo che serve a costruire lo spazio di testo in cui l'utente pu� inserire la sua password
         * @param {string} contenuto stringa che serve a settare il testo della label associata all'elemento password
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HMTLInputElement password configurato
         */
        static costruisciPassword(contenuto) {
            let password = document.createElement("input");
            password.type = "password";
            password.name = contenuto;
            let divPassword = document.createElement("div");
            divPassword.className = "form-group";
            $(divPassword).append(GestioneElementi.costruisciEtichetta(contenuto), password);
            return divPassword;
        }
        /**
         * Metodo che serve a costruire la checkbox che pu� essere spuntata dall'utente
         * @param {string} nome stringa associata al nome della checkbox
         * @param {string} altezza stringa associata all'attributo che consente di modificare l'altezza della checkbox
         * @param {string} larghezza stringa associata all'attributo che consente di modificare la larghezza della checkbox
         * @return {HTMLInputElement} un HTMLInputElement che rappresenta la checkbox configurata
         */
        static costruisciCheckbox(nome, altezza, larghezza) {
            let checkbox = document.createElement("input");
            checkbox.type = "checkbox";
            checkbox.name = nome;
            $(checkbox).css("width", larghezza).css("height", altezza);
            return checkbox;
        }
        /**
         * Metodo che serve a costruire il contenitore della checkbox
         * @param {HTMLInputElement} checkbox HTMLInputElement che viene appeso al contenitore
         * @param {HTMLLabelElement} label HTMLLabelElement associato alla checkbox
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement configurato
         */
        static divCheckbox(checkbox, label) {
            let divCheckbox = document.createElement("div");
            divCheckbox.className = "form-group";
            $(divCheckbox).append(checkbox, label);
            return divCheckbox;
        }
        /**
         * Metodo che serve per costruire un'etichetta testuale
         * @param {string} testo stringa corrispondente al contenuto dell'etichetta
         * @return {HTMLLabelElement} un HTMLLabelElement che rappresenta l'etichetta configurata
         */
        static costruisciEtichetta(testo) {
            let label = document.createElement("label");
            label.textContent = testo;
            return label;
        }
        /**
         * Metodo che serve per costruire il contenitore dell'etichetta
         * @param {HTMLLabelElement} etichetta HTMLLabelElement che viene appeso al contenitore
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLLabelElement configurato
         */
        static divEtichetta(etichetta) {
            let divLabel = document.createElement("div");
            divLabel.className = "form-group";
            $(divLabel).append(etichetta);
            return divLabel;
        }
        /**
         * Metodo che serve per settare degli attributi CSS di ciascuna label presente nell'array passato come parametro
         * @param {Array} arrayLabel array di HTMLLabelElement che contiene i riferimenti alle etichette testuali di cui si vogliono settare gli attributi
         * @param {string} display stringa associata all'attributo che permette di modificare il display della label
         * @param {string} align stringa associata all'attributo che permette di modificare l'allineamento testuale della label
         */
        static setLabelAttributes(arrayLabel, display, align) {
            for (let i = 0; i < arrayLabel.length; i++) {
                {
                    $(arrayLabel[i]).css("display", display).css("vertical-align", align);
                }
                ;
            }
        }
        /**
         * Metodo che serve per settare degli attributi CSS di ciascun Div presente nell'array passato come parametro
         * @param {Array} arrayDiv array di HTMLDivElement che contiene i riferimenti ai contenitori di cui si vogliono settare gli attributi
         * @param {string} margine stringa associata all'attributo che consente di modificare la posizione del Div all'interno della pagina
         * @param {string} lunghezza stringa associata all'attributo che consente di modificare la lunghezza del Div
         * @param {string} stile stringa associata all'attributo che consente di modificare lo stile del Div
         * @param {string} colore stringa associata all'attributo che consente di modificare il colore del Div
         * @param {string} spessore stringa associata all'attributo che consente di modificare lo spessore del Div
         * @param {string} altezza stringa associata all'attributo che consente di modificare l'altezza del Div
         */
        static setDivAttributes(arrayDiv, margine, lunghezza, stile, colore, spessore, altezza) {
            for (let i = 0; i < arrayDiv.length; i++) {
                {
                    $(arrayDiv[i]).css("margin", margine).css("border-width", spessore).css("border-style", stile).css("border-color", "#007fff").css("width", lunghezza).css("height", altezza);
                }
                ;
            }
        }
        /**
         * Metodo che serve per costruire un'area di testo
         * @param {string} testo stringa contenuta nell'etichetta associata all'area di testo
         * @param {string} altezza stringa associata all'attributo che permette di modificare l'altezza dell'area di testo
         * @param {string} larghezza stringa associata all'attributo che permette di modificare la larghezza dell'area di testo
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLTextAreaElement configurato
         */
        static costruisciTextArea(testo, altezza, larghezza) {
            let textAreaTask = document.createElement("textarea");
            textAreaTask.name = "textAreaTask";
            textAreaTask.className = "form-control";
            textAreaTask.placeholder = "Inserisci qui la tua risposta";
            $(textAreaTask).css("width", larghezza).css("height", altezza);
            let divTask = document.createElement("div");
            divTask.className = "form-group";
            let label = GestioneElementi.costruisciEtichetta(testo);
            $(label).css("white-space", "nowrap").css("font-weight", "bold");
            $(divTask).append(label, textAreaTask);
            return divTask;
        }
        /**
         * Metodo che permette di creare un elenco con delle opzioni
         * @param {string} nome stringa corrispondente al nome dell'HTMLSelectElement
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLSelectElement configurato
         */
        static costruisciSelect(nome) {
            let selezione = document.createElement("select");
            selezione.name = nome;
            let primaOpzione = document.createElement("option");
            primaOpzione.text = "...";
            selezione.add(primaOpzione);
            let listaOpzioni = GestioneElementi.creaOpzioni((["Francese", "Russo", "Spagnolo", "Tedesco"].slice(0)));
            for (let index121 = 0; index121 < listaOpzioni.length; index121++) {
                let o = listaOpzioni[index121];
                selezione.add(o);
            }
            let divSelezione = document.createElement("div");
            divSelezione.className = "form-group";
            $(divSelezione).append(selezione);
            return divSelezione;
        }
        /**
         * Metodo che serve per costruire un elemento non visibile all'interno della pagina
         * @param {string} nome stringa associata al nome dell'HTMLInputElement nascosto
         * @return {HTMLInputElement} un HTMLInputElement con type hidden configurato
         */
        static costruisciHidden(nome) {
            let inputHidden = document.createElement("input");
            inputHidden.type = "text";
            inputHidden.hidden = true;
            inputHidden.name = nome;
            return inputHidden;
        }
        /**
         * Metodo che serve per costruire un elemento che pu� subire l'azione di trascinamento
         * @return {HTMLDivElement} un HTMLDivElement configurato affinch� possa essere trascinabile
         */
        static costruisciDrag() {
            let divLettera = document.createElement("div");
            $(divLettera).css("border-width", "5px").css("border-style", "solid").css("border-color", "#ffffff").css("font-size", "50px").css("margin", "8% 8%").css("font-family", "Comic Sans").css("text-align", "center").css("display", "inline").css("vertical-align", "top").attr("draggable", "true").on("dragstart", (event, data) => {
                let dataTransfer = (event.originalEvent["dataTransfer"]);
                dataTransfer.setData("char", $(event.target).text());
                dataTransfer.effectAllowed = "move";
                return null;
            }).on("dragend", ((divLettera) => {
                return (event, data) => {
                    let dataTransfer = (event.originalEvent["dataTransfer"]);
                    event.preventDefault();
                    if (!((o1, o2) => { if (o1 && o1.equals) {
                        return o1.equals(o2);
                    }
                    else {
                        return o1 === o2;
                    } })(dataTransfer.dropEffect, "none")) {
                        $(divLettera).attr("draggable", "false").css("border-style", "dashed");
                    }
                    return null;
                };
            })(divLettera));
            return divLettera;
        }
        /**
         * Metodo che serve per costruire un elemento che pu� subire l'azione di rilascio
         * @param {HTMLInputElement} inputHidden HTMLInputElement con type hidden il cui valore verr� settato con il testo dell'elemento trascinato
         * @return {HTMLDivElement} un HTMLDivElement configurato affinch� possa accettare gli elementi trascinati
         */
        static costruisciDrop(inputHidden) {
            let divDestinazione = document.createElement("div");
            $(divDestinazione).css("border-width", "5px").css("border-style", "dashed").css("border-color", "#007fff").css("display", "inline").text("_").css("font-size", "50px").css("margin", "50% 8%").on("dragover", (event, data) => {
                event.preventDefault();
                return null;
            }).on("drop", ((divDestinazione) => {
                return (event, data) => {
                    event.preventDefault();
                    $(divDestinazione).css("border-style", "solid");
                    let target = $(event.target);
                    let dataTransfer = (event.originalEvent["dataTransfer"]);
                    target.text(dataTransfer.getData("char"));
                    $(inputHidden).attr("value", dataTransfer.getData("char"));
                    return null;
                };
            })(divDestinazione));
            return divDestinazione;
        }
        /**
         * Metodo che serve per costruire le opzioni che fanno parte dell'HTMLSelectElement
         * @param {string[]} opzioni ArrayList di stringhe corrispondenti al testo che verr� associato ai vari HTMLOptionElement
         * @return {HTMLOptionElement[]} un ArrayList di HTMLOptionElement utile ad aggiungere opzioni all'elenco
         * @private
         */
        /*private*/ static creaOpzioni(opzioni) {
            let listaOpzioni = ([]);
            for (let index122 = 0; index122 < opzioni.length; index122++) {
                let s = opzioni[index122];
                {
                    let opzioneA1 = document.createElement("option");
                    let opzioneA2 = document.createElement("option");
                    let opzioneB1 = document.createElement("option");
                    let opzioneB2 = document.createElement("option");
                    let opzioneC1 = document.createElement("option");
                    let opzioneC2 = document.createElement("option");
                    opzioneA1.text = s + " (A1)";
                    opzioneA2.text = s + " (A2)";
                    opzioneB1.text = s + " (B1)";
                    opzioneB2.text = s + " (B2)";
                    opzioneC1.text = s + " (C1)";
                    opzioneC2.text = s + " (C2)";
                    /* addAll */ ((l1, l2) => l1.push.apply(l1, l2))(listaOpzioni, /* asList */ [opzioneA1, opzioneA2, opzioneB1, opzioneB2, opzioneC1, opzioneC2]);
                }
            }
            return listaOpzioni;
        }
    }
    quickstart.GestioneElementi = GestioneElementi;
    GestioneElementi["__class"] = "quickstart.GestioneElementi";
})(quickstart || (quickstart = {}));
