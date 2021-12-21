/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che rappresenta la costruzione della pagina HTML di validazione "annotationValidation"
     * @class
     * @extends quickstart.AnnotationValidation
     */
    export class TranslationValidation extends quickstart.AnnotationValidation {
        /**
         * Stringa che indica l'URL della servlet a cui si vogliono inviare i dati
         */
        public static SERVLET_URL : string = "translationValidation.jsp";

        /**
         * Stringa che identifica il nome della task
         */
        public static TASK_NAME : string = "task=TRANSLATION_VALIDATION";

        public static main(args : string[]) {
            let form1 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(TranslationValidation.SERVLET_URL, "5% 20%");
            let form2 : HTMLFormElement = quickstart.GestioneElementi.costruisciForm(quickstart.AnnotationValidation.RANDOM_URL_$LI$(), "-10% 62%");
            let richiesta : HTMLLabelElement = quickstart.GestioneElementi.costruisciEtichetta("Selezionare la traduzione pi\u00f9 consona della parola seguente tra quelle proposte");
            $(richiesta).css("font-weight", "bold");
            let word : HTMLLabelElement = document.createElement("label");
            let description : HTMLLabelElement = document.createElement("label");
            $(description).css("font-style", "italic");
            let hiddenWord : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenWord");
            let hiddenDescription : HTMLInputElement = quickstart.GestioneElementi.costruisciHidden("hiddenDescription");
            let translation1 : HTMLLabelElement = document.createElement("label");
            let translation2 : HTMLLabelElement = document.createElement("label");
            let translation3 : HTMLLabelElement = document.createElement("label");
            let noTranslation : HTMLLabelElement = quickstart.GestioneElementi.costruisciEtichetta("Nessuna delle traduzioni proposte \u00e8 corretta");
            quickstart.GestioneElementi.setLabelAttributes([translation1, translation2, translation3, noTranslation], "inline", "top");
            let checkbox1 : HTMLInputElement = quickstart.GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
            let checkbox2 : HTMLInputElement = quickstart.GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
            let checkbox3 : HTMLInputElement = quickstart.GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
            let checkbox4 : HTMLInputElement = quickstart.GestioneElementi.costruisciCheckbox("checkboxTranslations", "26px", "26px");
            $.getJSON(quickstart.AnnotationValidation.REST_URL, TranslationValidation.TASK_NAME, ((checkbox1,hiddenDescription,checkbox2,hiddenWord,description,translation1,translation2,translation3,checkbox3,checkbox4,word) => {
                return (result, a, ctx) => {
                    let json : JSON = <JSON>result;
                    let sWord : string = <any>(json["word"]);
                    let sDescription : string = <any>(json["description"]);
                    let sTranslation1 : string = <any>(json["firstTranslation"]);
                    let sTranslation2 : string = <any>(json["secondTranslation"]);
                    let sTranslation3 : string = <any>(json["thirdTranslation"]);
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
                }
            })(checkbox1,hiddenDescription,checkbox2,hiddenWord,description,translation1,translation2,translation3,checkbox3,checkbox4,word));
            let divSpazio : HTMLDivElement = document.createElement("div");
            $(divSpazio).css("height", "20px");
            let divHidden : HTMLDivElement = document.createElement("div");
            $(divHidden).append(hiddenWord, hiddenDescription);
            let divCb1 : HTMLDivElement = quickstart.GestioneElementi.divCheckbox(checkbox1, translation1);
            let divCb2 : HTMLDivElement = quickstart.GestioneElementi.divCheckbox(checkbox2, translation2);
            let divCb3 : HTMLDivElement = quickstart.GestioneElementi.divCheckbox(checkbox3, translation3);
            let divCb4 : HTMLDivElement = quickstart.GestioneElementi.divCheckbox(checkbox4, noTranslation);
            quickstart.GestioneElementi.setDivAttributes([divCb1, divCb2, divCb3, divCb4], "1px", "76%", "solid", "#007fff", "2px", "4%");
            $(form1).append(quickstart.GestioneElementi.divEtichetta(richiesta), quickstart.GestioneElementi.divEtichetta(word), quickstart.GestioneElementi.divEtichetta(description), divCb1, divCb2, divCb3, divCb4, divSpazio, divHidden);
            AnnotationValidation.addLinksAndButtons(form1, form2, "5% 0%");
        }
    }
    TranslationValidation["__class"] = "quickstart.TranslationValidation";

}


quickstart.TranslationValidation.main(null);
