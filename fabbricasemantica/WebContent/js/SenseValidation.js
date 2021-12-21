/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la pagina HTML di validazione "annotationValidation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    class SenseValidation extends quickstart.AnnotationValidation {
        static main(args) {
            let form1 = quickstart.GestioneElementi.costruisciForm(SenseValidation.SERVLET_URL, "5% 20%");
            let form2 = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 43%");
            let richiesta = quickstart.GestioneElementi.costruisciEtichetta("Indicare se il senso che appare nel riquadro \u00e8 coerente o meno con la parola fornita");
            $(richiesta).css("font-weight", "bold");
            let word = document.createElement("label");
            let example = document.createElement("label");
            $(example).css("font-style", "italic");
            let sense = document.createElement("label");
            let hiddenWord = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenExample = quickstart.GestioneElementi.costruisciHidden("hiddenExample");
            let hiddenSense = quickstart.GestioneElementi.costruisciHidden("hiddenSense");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, SenseValidation.TASK_NAME, ((hiddenSense, hiddenWord, sense, hiddenExample, word, example) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sExample = (json["example"]);
                    let sSense = (json["sense"]);
                    $(word).text(sWord);
                    $(example).text(sExample);
                    $(sense).text(sSense);
                    $(hiddenWord).attr("value", sWord);
                    $(hiddenExample).attr("value", sExample);
                    $(hiddenSense).attr("value", sSense);
                    return null;
                };
            })(hiddenSense, hiddenWord, sense, hiddenExample, word, example));
            let divSense = quickstart.GestioneElementi.divEtichetta(sense);
            quickstart.GestioneElementi.setDivAttributes([divSense], "", "400px", "outset", "#007fff", "5px", "200px");
            $(form1).append(quickstart.GestioneElementi.divEtichetta(richiesta), quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(example), divSense, hiddenWord, hiddenExample, hiddenSense, quickstart.GestionePulsanti.costruisciRadio("Si"), quickstart.GestionePulsanti.costruisciRadio("No"));
            quickstart.AnnotationValidation.addLinksAndButtons(form1, form2, "5% 0%");
        }
    }
    /**
     * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
     */
    SenseValidation.SERVLET_URL = "senseValidation.jsp";
    /**
     * Stringa che identifica il nome della task
     */
    SenseValidation.TASK_NAME = "task=SENSE_VALIDATION";
    quickstart.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "quickstart.SenseValidation";
})(quickstart || (quickstart = {}));
quickstart.SenseValidation.main(null);
