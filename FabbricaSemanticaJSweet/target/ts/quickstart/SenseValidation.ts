/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la pagina HTML di validazione "annotationValidation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    export class SenseValidation extends quickstart.AnnotationValidation {
        /**
         * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
         */
        public static SERVLET_URL : string = "senseValidation.jsp";

        /**
         * Stringa che identifica il nome della task
         */
        public static TASK_NAME : string = "task=SENSE_VALIDATION";

        public static main(args : string[]) {
            let form1 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(SenseValidation.SERVLET_URL, "5% 20%");
            let form2 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 43%");
            let richiesta : HTMLLabelElement = quickstart.GestioneElementi.costruisciEtichetta("Indicare se il senso che appare nel riquadro \u00e8 coerente o meno con la parola fornita");
            $(richiesta).css("font-weight", "bold");
            let word : HTMLLabelElement = document.createElement("label");
            let example : HTMLLabelElement = document.createElement("label");
            $(example).css("font-style", "italic");
            let sense : HTMLLabelElement = document.createElement("label");
            let hiddenWord : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenExample : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenExample");
            let hiddenSense : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenSense");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, SenseValidation.TASK_NAME, ((hiddenSense,hiddenWord,sense,hiddenExample,word,example) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sExample : string = <any>(json["example"]);
                    let sSense : string = <any>(json["sense"]);
                    $(word).text(sWord);
                    $(example).text(sExample);
                    $(sense).text(sSense);
                    $(hiddenWord).attr("value", sWord);
                    $(hiddenExample).attr("value", sExample);
                    $(hiddenSense).attr("value", sSense);
                    return null;
                }
            })(hiddenSense,hiddenWord,sense,hiddenExample,word,example));
            let divSense : HTMLDivElement = quickstart.GestioneElementi.divEtichetta(sense);
            quickstart.GestioneElementi.setDivAttributes([divSense], "", "400px", "outset", "#007fff", "5px", "200px");
            $(form1).append(quickstart.GestioneElementi.divEtichetta(richiesta), quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(example), divSense, hiddenWord, hiddenExample, hiddenSense, quickstart.GestionePulsanti.costruisciRadio("Si"), quickstart.GestionePulsanti.costruisciRadio("No"));
            AnnotationValidation.addLinksAndButtons(form1, form2, "5% 0%");
        }
    }
    SenseValidation["__class"] = "quickstart.SenseValidation";

}


quickstart.SenseValidation.main(null);
