/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di annotazione "senseAnnotation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    class SenseAnnotation extends quickstart.AnnotationValidation {
        static main(args) {
            let form1 = quickstart.GestioneElementi.costruisciForm(SenseAnnotation.SERVLET_URL, "5% 20%");
            let form2 = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 76%");
            let richiesta = quickstart.GestioneElementi.costruisciEtichetta("Selezionare il senso che pi\u00f9 si addice alla seguente parola");
            $(richiesta).css("font-weight", "bold");
            let word = document.createElement("label");
            let description = document.createElement("label");
            $(description).css("font-style", "italic");
            let hiddenWord = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenDescription = quickstart.GestioneElementi.costruisciHidden("hiddenDescription");
            let sense1 = document.createElement("label");
            let sense2 = document.createElement("label");
            let sense3 = document.createElement("label");
            let sense4 = document.createElement("label");
            quickstart.GestioneElementi.setLabelAttributes([sense1, sense2, sense3, sense4], "inline", "top");
            let checkbox1 = quickstart.GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
            let checkbox2 = quickstart.GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
            let checkbox3 = quickstart.GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
            let checkbox4 = quickstart.GestioneElementi.costruisciCheckbox("checkboxSenses", "26px", "26px");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, SenseAnnotation.TASK_NAME, ((sense1, sense2, sense3, sense4, checkbox1, hiddenDescription, checkbox2, hiddenWord, description, checkbox3, checkbox4, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sSense1 = (json["firstSense"]);
                    let sSense2 = (json["secondSense"]);
                    let sSense3 = (json["thirdSense"]);
                    let sSense4 = (json["fourthSense"]);
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
                };
            })(sense1, sense2, sense3, sense4, checkbox1, hiddenDescription, checkbox2, hiddenWord, description, checkbox3, checkbox4, word));
            let divHidden = document.createElement("div");
            $(divHidden).append(hiddenWord, hiddenDescription);
            let divSpazio = document.createElement("div");
            $(divSpazio).css("height", "20px");
            let divCb1 = quickstart.GestioneElementi.divCheckbox(checkbox1, sense1);
            let divCb2 = quickstart.GestioneElementi.divCheckbox(checkbox2, sense2);
            let divCb3 = quickstart.GestioneElementi.divCheckbox(checkbox3, sense3);
            let divCb4 = quickstart.GestioneElementi.divCheckbox(checkbox4, sense4);
            quickstart.GestioneElementi.setDivAttributes([divCb1, divCb2, divCb3, divCb4], "1px", "99%", "solid", "#007fff", "2px", "4%");
            $(form1).append(quickstart.GestioneElementi.divEtichetta(richiesta), quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(description), divCb1, divCb2, divCb3, divCb4, divSpazio, divHidden);
            quickstart.AnnotationValidation.addLinksAndButtons(form1, form2, "5% 0%");
        }
    }
    /**
     * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
     */
    SenseAnnotation.SERVLET_URL = "senseAnnotation.jsp";
    /**
     * Stringa che identifica il nome della task
     */
    SenseAnnotation.TASK_NAME = "task=SENSE_ANNOTATION";
    quickstart.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "quickstart.SenseAnnotation";
})(quickstart || (quickstart = {}));
quickstart.SenseAnnotation.main(null);
