(ns devcards-sg.core
  (:require
   [sablono.core :as sab :include-macros true]
   [devcards-sg.introduction]
   [devcards-sg.workflow]
   [devcards-sg.conclusion]))

(enable-console-print!)

(defn main []
  ;; conditionally start the app based on whether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (.render js/ReactDOM (sab/html [:div "This is working"]) node)))

(main)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html

