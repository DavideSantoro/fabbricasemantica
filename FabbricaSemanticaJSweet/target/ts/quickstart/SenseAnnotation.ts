/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di annotazione "senseAnnotation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    export class SenseAnnotation extends quickstart.AnnotationValidation {
        /**
         * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
         */
        public static SERVLET_URL : string = "senseAnnotation.jsp";

        /**
         * Stringa che identifica il nome della task
         */
        public static TASK_NAME : string = "task=SENSE_ANNOTATION";

        public static main(args : string[]) {
            let form1 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(SenseAnnotation.SERVLET_URL, "5% 20%");
            let form2 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 76%");
            let richiesta : HTMLLabelElement = quickstart.GestioneElementi.costruisciEtichetta("Selezionare il senso che pi\u00f9 si addice alla seguente parola");
            $(richiesta).css("font-weight", "bold");
            let word : HTMLLabelElement = document.createElement("label");
            let description : HTMLLabelElement = document.createElement("label");
            $(description).css("font-style", "italic");
            let hiddenWord : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenDescription : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenDescription");
            let sense1 : HTMLLabelElement = document.createElement("label");
            let sense2 : HTMLLabelElement = document.createElement("label");
            let sense3 : HTMLLabelElement = document.createElement("label");
            let sense4 : HTMLLabelElement = document.createElement("label");
            quickstart.GestioneElementi.setLabelAttributes([sense1, sense2, sense3, sense4], "inline", "top");
            let checkbox1 : HTMLInputElement = quickstart.GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
            let checkbox2 : HTMLInputElement = quickstart.GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
            let checkbox3 : HTMLInputElement = quickstart.GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
            let checkbox4 : HTMLInputElement = quickstart.GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, SenseAnnotation.TASK_NAME, ((sense1,sense2,sense3,sense4,checkbox1,hiddenDescription,checkbox2,hiddenWord,description,checkbox3,checkbox4,word) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sDescription : string = <any>(json["description"]);
                    let sSense1 : string = <any>(json["firstSense"]);
                    let sSense2 : string = <any>(json["secondSense"]);
                    let sSense3 : string = <any>(json["thirdSense"]);
                    let sSense4 : string = <any>(json["fourthSense"]);
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    $(sense1).text(sSense1);
                    $(sense2).text(sSense2);
                    $(sense3).text(sSense3);
                    $(sense4).text(sSense4);
                    $(checkbox1).attr("value", sSense1);
                    $(checkbox2).attr("value", sSense2);
                    $(checkbox3).attr("value", sSense3);
                    $(checkbox4).attr("value", sSense4);
                    $(hiddenWord).attr("value", sWord);
                    $(hiddenDescription).attr("value", sDescription);
                    return null;
                }
            })(sense1,sense2,sense3,sense4,checkbox1,hiddenDescription,checkbox2,hiddenWord,description,checkbox3,checkbox4,word));
            let divHidden : HTMLDivElement = document.createElement("div");
            $(divHidden).append(hiddenWord, hiddenDescription);
            let divSpazio : HTMLDivElement = document.createElement("div");
            $(divSpazio).css("height", "20px");
            let divCb1 : HTMLDivElement = quickstart.GestioneElementi.divCheckbox(checkbox1, sense1);
            let divCb2 : HTMLDivElement = quickstart.GestioneElementi.divCheckbox(checkbox2, sense2);
            let divCb3 : HTMLDivElement = quickstart.GestioneElementi.divCheckbox(checkbox3, sense3);
            let divCb4 : HTMLDivElement = quickstart.GestioneElementi.divCheckbox(checkbox4, sense4);
            quickstart.GestioneElementi.setDivAttributes([divCb1, divCb2, divCb3, divCb4], "1px", "99%", "solid", "#007fff", "2px", "4%");
            $(form1).append(quickstart.GestioneElementi.divEtichetta(richiesta), quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(description), divCb1, divCb2, divCb3, divCb4, divSpazio, divHidden);
            AnnotationValidation.addLinksAndButtons(form1, form2, "5% 0%");
        }
    }
    SenseAnnotation["__class"] = "quickstart.SenseAnnotation";

}


quickstart.SenseAnnotation.main(null);
