/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di annotazione "definitionAnnotation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    class DefinitionAnnotation extends quickstart.AnnotationValidation {
        static main(args) {
            let form1 = quickstart.GestioneElementi.costruisciForm(DefinitionAnnotation.SERVLET_URL, "5% 20%");
            let form2 = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 67%");
            let word = document.createElement("label");
            let hypernym = document.createElement("label");
            let hiddenWord = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenHypernym = quickstart.GestioneElementi.costruisciHidden("hiddenHypernym");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, DefinitionAnnotation.TASK_NAME, ((hiddenWord, hypernym, word, hiddenHypernym) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sHypernym = (json["hypernym"]);
                    $(word).text(sWord);
                    $(hypernym).text(sHypernym);
                    $(hiddenWord).attr("value", sWord);
                    $(hiddenHypernym).attr("value", sHypernym);
                    return null;
                };
            })(hiddenWord, hypernym, word, hiddenHypernym));
            $(form1).append(quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(hypernym), hiddenWord, hiddenHypernym, quickstart.GestioneElementi.costruisciTextArea("Sulla base della parola fornita e del suo iperonimo, scrivere la definizione opportuna", "150px", "770px"));
            quickstart.AnnotationValidation.addLinksAndButtons(form1, form2, "5% 100%");
        }
    }
    /**
     * Stringa che rappresenta l'indirizzo della servlet a cui mandare i dati una volta fatto il submit della form
     */
    DefinitionAnnotation.SERVLET_URL = "definitionAnnotation.jsp";
    /**
     * Stringa che corrisponde al nome del task
     */
    DefinitionAnnotation.TASK_NAME = "task=DEFINITION_ANNOTATION";
    quickstart.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "quickstart.DefinitionAnnotation";
})(quickstart || (quickstart = {}));
quickstart.DefinitionAnnotation.main(null);
