/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di annotazione "definitionAnnotation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    export class DefinitionAnnotation extends quickstart.AnnotationValidation {
        /**
         * Stringa che rappresenta l'indirizzo della servlet a cui mandare i dati una volta fatto il submit della form
         */
        public static SERVLET_URL : string = "definitionAnnotation.jsp";

        /**
         * Stringa che corrisponde al nome del task
         */
        public static TASK_NAME : string = "task=DEFINITION_ANNOTATION";

        public static main(args : string[]) {
            let form1 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(DefinitionAnnotation.SERVLET_URL, "5% 20%");
            let form2 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 67%");
            let word : HTMLLabelElement = document.createElement("label");
            let hypernym : HTMLLabelElement = document.createElement("label");
            let hiddenWord : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenHypernym : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenHypernym");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, DefinitionAnnotation.TASK_NAME, ((hiddenWord,hypernym,word,hiddenHypernym) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sHypernym : string = <any>(json["hypernym"]);
                    $(word).text(sWord);
                    $(hypernym).text(sHypernym);
                    $(hiddenWord).attr("value", sWord);
                    $(hiddenHypernym).attr("value", sHypernym);
                    return null;
                }
            })(hiddenWord,hypernym,word,hiddenHypernym));
            $(form1).append(quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(hypernym), hiddenWord, hiddenHypernym, quickstart.GestioneElementi.costruisciTextArea("Sulla base della parola fornita e del suo iperonimo, scrivere la definizione opportuna", "150px", "770px"));
            AnnotationValidation.addLinksAndButtons(form1, form2, "5% 100%");
        }
    }
    DefinitionAnnotation["__class"] = "quickstart.DefinitionAnnotation";

}


quickstart.DefinitionAnnotation.main(null);
