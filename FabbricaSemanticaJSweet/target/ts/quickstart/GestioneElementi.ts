/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che dispone di metodi statici utili alla configurazione e alla costruzione
     * degli elementi che compongono la struttura delle pagine HTML
     * @class
     */
    export class GestioneElementi {
        /**
         * Metodo che serve per la costruzione di una form
         * @param {string} servlet stringa corrispondente all'URL a cui va inviato il messaggio per fare il submit
         * @param {string} margine stringa associata all'attributo che permette di modificare la posizione della form all'interno della pagina
         * @return {HTMLFormElement} un HTMLFormElement che rappresenta il contenitore principale
         */
        public static costruisciForm(servlet : string, margine : string) : HTMLFormElement {
            let form : HTMLFormElement = document.createElement("form");
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
        public static costruisciTitolo(titolo : string) : HTMLDivElement {
            let labelTitle : HTMLLabelElement = GestioneElementi.costruisciEtichetta(titolo);
            $(labelTitle).css("font-weight", "bold").css("font-size", "23px");
            return GestioneElementi.divEtichetta(labelTitle);
        }

        /**
         * Metodo che serve a costruire lo spazio di testo in cui l'utente può inserire la sua email
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLInputElement email
         */
        public static costruisciEmail() : HTMLDivElement {
            let emailAddress : HTMLInputElement = document.createElement("input");
            emailAddress.type = "email";
            emailAddress.name = "email";
            let divEmailAddress : HTMLDivElement = document.createElement("div");
            divEmailAddress.className = "form-group";
            $(divEmailAddress).append(GestioneElementi.costruisciEtichetta("Email"), emailAddress);
            return divEmailAddress;
        }

        /**
         * Metodo che serve a costruire lo spazio di testo in cui l'utente può inserire la sua password
         * @param {string} contenuto stringa che serve a settare il testo della label associata all'elemento password
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HMTLInputElement password configurato
         */
        public static costruisciPassword(contenuto : string) : HTMLDivElement {
            let password : HTMLInputElement = document.createElement("input");
            password.type = "password";
            password.name = contenuto;
            let divPassword : HTMLDivElement = document.createElement("div");
            divPassword.className = "form-group";
            $(divPassword).append(GestioneElementi.costruisciEtichetta(contenuto), password);
            return divPassword;
        }

        /**
         * Metodo che serve a costruire la checkbox che può essere spuntata dall'utente
         * @param {string} nome stringa associata al nome della checkbox
         * @param {string} altezza stringa associata all'attributo che consente di modificare l'altezza della checkbox
         * @param {string} larghezza stringa associata all'attributo che consente di modificare la larghezza della checkbox
         * @return {HTMLInputElement} un HTMLInputElement che rappresenta la checkbox configurata
         */
        public static costruisciCheckbox(nome : string, altezza : string, larghezza : string) : HTMLInputElement {
            let checkbox : HTMLInputElement = document.createElement("input");
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
        public static divCheckbox(checkbox : HTMLInputElement, label : HTMLLabelElement) : HTMLDivElement {
            let divCheckbox : HTMLDivElement = document.createElement("div");
            divCheckbox.className = "form-group";
            $(divCheckbox).append(checkbox, label);
            return divCheckbox;
        }

        /**
         * Metodo che serve per costruire un'etichetta testuale
         * @param {string} testo stringa corrispondente al contenuto dell'etichetta
         * @return {HTMLLabelElement} un HTMLLabelElement che rappresenta l'etichetta configurata
         */
        public static costruisciEtichetta(testo : string) : HTMLLabelElement {
            let label : HTMLLabelElement = document.createElement("label");
            label.textContent = testo;
            return label;
        }

        /**
         * Metodo che serve per costruire il contenitore dell'etichetta
         * @param {HTMLLabelElement} etichetta HTMLLabelElement che viene appeso al contenitore
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLLabelElement configurato
         */
        public static divEtichetta(etichetta : HTMLLabelElement) : HTMLDivElement {
            let divLabel : HTMLDivElement = document.createElement("div");
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
        public static setLabelAttributes(arrayLabel : HTMLLabelElement[], display : string, align : string) {
            for(let i : number = 0; i < arrayLabel.length; i++) {{
                $(arrayLabel[i]).css("display", display).css("vertical-align", align);
            };}
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
        public static setDivAttributes(arrayDiv : HTMLDivElement[], margine : string, lunghezza : string, stile : string, colore : string, spessore : string, altezza : string) {
            for(let i : number = 0; i < arrayDiv.length; i++) {{
                $(arrayDiv[i]).css("margin", margine).css("border-width", spessore).css("border-style", stile).css("border-color", "#007fff").css("width", lunghezza).css("height", altezza);
            };}
        }

        /**
         * Metodo che serve per costruire un'area di testo
         * @param {string} testo stringa contenuta nell'etichetta associata all'area di testo
         * @param {string} altezza stringa associata all'attributo che permette di modificare l'altezza dell'area di testo
         * @param {string} larghezza stringa associata all'attributo che permette di modificare la larghezza dell'area di testo
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLTextAreaElement configurato
         */
        public static costruisciTextArea(testo : string, altezza : string, larghezza : string) : HTMLDivElement {
            let textAreaTask : HTMLTextAreaElement = document.createElement("textarea");
            textAreaTask.name = "textAreaTask";
            textAreaTask.className = "form-control";
            textAreaTask.placeholder = "Inserisci qui la tua risposta";
            $(textAreaTask).css("width", larghezza).css("height", altezza);
            let divTask : HTMLDivElement = document.createElement("div");
            divTask.className = "form-group";
            let label : HTMLLabelElement = GestioneElementi.costruisciEtichetta(testo);
            $(label).css("white-space", "nowrap").css("font-weight", "bold");
            $(divTask).append(label, textAreaTask);
            return divTask;
        }

        /**
         * Metodo che permette di creare un elenco con delle opzioni
         * @param {string} nome stringa corrispondente al nome dell'HTMLSelectElement
         * @return {HTMLDivElement} un HTMLDivElement che contiene l'HTMLSelectElement configurato
         */
        public static costruisciSelect(nome : string) : HTMLDivElement {
            let selezione : HTMLSelectElement = document.createElement("select");
            selezione.name = nome;
            let primaOpzione : HTMLOptionElement = document.createElement("option");
            primaOpzione.text = "...";
            selezione.add(primaOpzione);
            let listaOpzioni : Array<HTMLOptionElement> = GestioneElementi.creaOpzioni(<any>(/* asList */["Francese", "Russo", "Spagnolo", "Tedesco"].slice(0)));
            for(let index121=0; index121 < listaOpzioni.length; index121++) {
                let o = listaOpzioni[index121];
                selezione.add(o)
            }
            let divSelezione : HTMLDivElement = document.createElement("div");
            divSelezione.className = "form-group";
            $(divSelezione).append(selezione);
            return divSelezione;
        }

        /**
         * Metodo che serve per costruire un elemento non visibile all'interno della pagina
         * @param {string} nome stringa associata al nome dell'HTMLInputElement nascosto
         * @return {HTMLInputElement} un HTMLInputElement con type hidden configurato
         */
        public static costruisciHidden(nome : string) : HTMLInputElement {
            let inputHidden : HTMLInputElement = document.createElement("input");
            inputHidden.type = "text";
            inputHidden.hidden = true;
            inputHidden.name = nome;
            return inputHidden;
        }

        /**
         * Metodo che serve per costruire un elemento che può subire l'azione di trascinamento
         * @return {HTMLDivElement} un HTMLDivElement configurato affinché possa essere trascinabile
         */
        public static costruisciDrag() : HTMLDivElement {
            let divLettera : HTMLDivElement = document.createElement("div");
            $(divLettera).css("border-width", "5px").css("border-style", "solid").css("border-color", "#ffffff").css("font-size", "50px").css("margin", "8% 8%").css("font-family", "Comic Sans").css("text-align", "center").css("display", "inline").css("vertical-align", "top").attr("draggable", "true").on("dragstart", (event, data) => {
                let dataTransfer : DataTransfer = <any>(event.originalEvent["dataTransfer"]);
                dataTransfer.setData("char", $(event.target).text());
                dataTransfer.effectAllowed = "move";
                return null;
            }).on("dragend", ((divLettera) => {
                return (event, data) => {
                    let dataTransfer : DataTransfer = <any>(event.originalEvent["dataTransfer"]);
                    event.preventDefault();
                    if(!/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(dataTransfer.dropEffect,"none"))) {
                        $(divLettera).attr("draggable", "false").css("border-style", "dashed");
                    }
                    return null;
                }
            })(divLettera));
            return divLettera;
        }

        /**
         * Metodo che serve per costruire un elemento che può subire l'azione di rilascio
         * @param {HTMLInputElement} inputHidden HTMLInputElement con type hidden il cui valore verrà settato con il testo dell'elemento trascinato
         * @return {HTMLDivElement} un HTMLDivElement configurato affinché possa accettare gli elementi trascinati
         */
        public static costruisciDrop(inputHidden : HTMLInputElement) : HTMLDivElement {
            let divDestinazione : HTMLDivElement = document.createElement("div");
            $(divDestinazione).css("border-width", "5px").css("border-style", "dashed").css("border-color", "#007fff").css("display", "inline").text("_").css("font-size", "50px").css("margin", "50% 8%").on("dragover", (event, data) => {
                event.preventDefault();
                return null;
            }).on("drop", ((divDestinazione) => {
                return (event, data) => {
                    event.preventDefault();
                    $(divDestinazione).css("border-style", "solid");
                    let target : JQuery = $(event.target);
                    let dataTransfer : DataTransfer = <any>(event.originalEvent["dataTransfer"]);
                    target.text(dataTransfer.getData("char"));
                    $(inputHidden).attr("value", dataTransfer.getData("char"));
                    return null;
                }
            })(divDestinazione));
            return divDestinazione;
        }

        /**
         * Metodo che serve per costruire le opzioni che fanno parte dell'HTMLSelectElement
         * @param {string[]} opzioni ArrayList di stringhe corrispondenti al testo che verrà associato ai vari HTMLOptionElement
         * @return {HTMLOptionElement[]} un ArrayList di HTMLOptionElement utile ad aggiungere opzioni all'elenco
         * @private
         */
        /*private*/ static creaOpzioni(opzioni : Array<string>) : Array<HTMLOptionElement> {
            let listaOpzioni : Array<HTMLOptionElement> = <any>([]);
            for(let index122=0; index122 < opzioni.length; index122++) {
                let s = opzioni[index122];
                {
                    let opzioneA1 : HTMLOptionElement = document.createElement("option");
                    let opzioneA2 : HTMLOptionElement = document.createElement("option");
                    let opzioneB1 : HTMLOptionElement = document.createElement("option");
                    let opzioneB2 : HTMLOptionElement = document.createElement("option");
                    let opzioneC1 : HTMLOptionElement = document.createElement("option");
                    let opzioneC2 : HTMLOptionElement = document.createElement("option");
                    opzioneA1.text = s + " (A1)";
                    opzioneA2.text = s + " (A2)";
                    opzioneB1.text = s + " (B1)";
                    opzioneB2.text = s + " (B2)";
                    opzioneC1.text = s + " (C1)";
                    opzioneC2.text = s + " (C2)";
                    /* addAll */((l1, l2) => l1.push.apply(l1, l2))(listaOpzioni, /* asList */[opzioneA1, opzioneA2, opzioneB1, opzioneB2, opzioneC1, opzioneC2]);
                }
            }
            return listaOpzioni;
        }
    }
    GestioneElementi["__class"] = "quickstart.GestioneElementi";

}

