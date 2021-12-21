/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di validazione "annotationValidation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    class TranslationValidation extends quickstart.AnnotationValidation {
        static main(args) {
            let form1 = quickstart.GestioneElementi.costruisciForm(TranslationValidation.SERVLET_URL, "5% 20%");
            let form2 = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 62%");
            let richiesta = quickstart.GestioneElementi.costruisciEtichetta("Selezionare la traduzione pi\u00f9 consona della parola seguente tra quelle proposte");
            $(richiesta).css("font-weight", "bold");
            let word = document.createElement("label");
            let description = document.createElement("label");
            $(description).css("font-style", "italic");
            let hiddenWord = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenDescription = quickstart.GestioneElementi.costruisciHidden("hiddenDescription");
            let translation1 = document.createElement("label");
            let translation2 = document.createElement("label");
            let translation3 = document.createElement("label");
            let noTranslation = quickstart.GestioneElementi.costruisciEtichetta("Nessuna delle traduzioni proposte \u00e8 corretta");
            quickstart.GestioneElementi.setLabelAttributes([translation1, translation2, translation3, noTranslation], "inline", "top");
            let checkbox1 = quickstart.GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
            let checkbox2 = quickstart.GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
            let checkbox3 = quickstart.GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
            let checkbox4 = quickstart.GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, TranslationValidation.TASK_NAME, ((checkbox1, hiddenDescription, checkbox2, hiddenWord, description, translation1, translation2, translation3, checkbox3, checkbox4, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sTranslation1 = (json["firstTranslation"]);
                    let sTranslation2 = (json["secondTranslation"]);
                    let sTranslation3 = (json["thirdTranslation"]);
                    $(word).text(sWord);
                    $(description).text(sDescription);
                    $(translation1).text(sTranslation1);
                    $(translation2).text(sTranslation2);
                    $(translation3).text(sTranslation3);
                    $(checkbox1).attr("value", sTranslation1);
                    $(checkbox2).attr("value", sTranslation2);
                    $(checkbox3).attr("value", sTranslation3);
                    $(checkbox4).attr("value", "Nessuna");
                    $(hiddenWord).attr("value", sWord);
                    $(hiddenDescription).attr("value", sDescription);
                    return null;
                };
            })(checkbox1, hiddenDescription, checkbox2, hiddenWord, description, translation1, translation2, translation3, checkbox3, checkbox4, word));
            let divSpazio = document.createElement("div");
            $(divSpazio).css("height", "20px");
            let divHidden = document.createElement("div");
            $(divHidden).append(hiddenWord, hiddenDescription);
            let divCb1 = quickstart.GestioneElementi.divCheckbox(checkbox1, translation1);
            let divCb2 = quickstart.GestioneElementi.divCheckbox(checkbox2, translation2);
            let divCb3 = quickstart.GestioneElementi.divCheckbox(checkbox3, translation3);
            let divCb4 = quickstart.GestioneElementi.divCheckbox(checkbox4, noTranslation);
            quickstart.GestioneElementi.setDivAttributes([divCb1, divCb2, divCb3, divCb4], "1px", "76%", "solid", "#007fff", "2px", "4%");
            $(form1).append(quickstart.GestioneElementi.divEtichetta(richiesta), quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(description), divCb1, divCb2, divCb3, divCb4, divSpazio, divHidden);
            quickstart.AnnotationValidation.addLinksAndButtons(form1, form2, "5% 0%");
        }
    }
    /**
     * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
     */
    TranslationValidation.SERVLET_URL = "translationValidation.jsp";
    /**
     * Stringa che identifica il nome della task
     */
    TranslationValidation.TASK_NAME = "task=TRANSLATION_VALIDATION";
    quickstart.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "quickstart.TranslationValidation";
})(quickstart || (quickstart = {}));
quickstart.TranslationValidation.main(null);
