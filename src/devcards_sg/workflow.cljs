(ns devcards-sg.workflow
  (:require [devcards.core :as dc]
            [reagent.core :as rg]
            [cljs.test :as t :include-macros true :refer-macros [testing is]])
  (:require-macros [devcards.core :as dc :refer [defcard defcard-rg defcard-doc deftest]]))

(defcard
  "# Development workflow with devcards

   ## What I am using
   * Leiningen
   * Figwheel
   * Emacs & Cider

   ## What I am doing
   
   It's so simple!!!

   1. Open the project
   1. Press ```Ctrl-C Alt-Shift-J```
   1. Open ```http://localhost:3449/cards.html``` in your browser
   1. In your screen, put the browser & editor side by side

   ## What I am thinking

   1. Design
   1. Separate design to components
   1. Try and error with the 3rd party libraries
   1. Implement & test the components
   1. Put components together")

(defcard Design
  "It should be a decent system, blar blar...

   It should meet below requirements

   1. one
   1. two

   It should provide below features

   1. one
   1. two

   It looks like this

   <image src='./images/titanic.jpg' style='width: 100%;'>")



(defcard Play
  "## To test the position of image inside div"
  
  (dc/reagent [:div {:style {:width "800px"
                             :height "300px"}}
               [:img {:src "./images/sea.jpeg"
                      :style {:width "90%"
                              :height "70%"
                              :position :absolute
                              :bottom "10px"}}]]))

(defcard Play
  "## To test rotation"

  (dc/reagent [:div {:style {:width "100px" :height "100px"}}
               [:img {:src "./images/boat.png"
                      :style {:width "20%"
                              :height "60%"
                              :position :absolute
                              :bottom "30%"
                              :left "40%"
                              :transform "rotate(25deg)"}}]]))

(def count-click (atom 0))

(defn container
  [props & children]
  (into [:div props] children))

(defn c-sea
  []
  [:img {:src "./images/sea.jpeg"
         :style {:width "90%"
                 :height "70%"
                 :z-index "1"
                 :position :absolute
                 :bottom "90px"}}])
(defn c-boat
  [rot style]
  [:img {:src "./images/boat.png"
         :style (merge {:width "20%"
                        :height "40%"
                        :z-index "2"
                        :position :absolute
                        :bottom "180px"
                        :left "40%"
                        :transform (str "rotate(" (:degree @rot) "deg)")}
                       style)}])

(defcard Test
  "## Add some tests")

(deftest boat-test
  (testing "never sink"
    (is false "ship could sink."))
  (testing "could sink"
    (is true "there is always situation is not included in requirement.")))

(defcard Implementation
  "During implementation, we could put the code snippets in devcards or their own ns.

   To impelment a boat we promise like below: "
  (dc/mkdn-pprint-source c-boat))

(defcard-rg Integrate
  ""
  (fn [atom-degree _]
    [container {:style {:width "800px" :height "500px"}}
     [c-sea]
     [c-boat atom-degree {:bottom "290px"}]
     [:img {:src "./images/pump.png"
            :style {:z-index "5"
                    :position :absolute}
            :on-click #(swap! atom-degree update :degree dec 2)}]])
  
  (rg/atom {:degree 40})
  
  {:inspect-data true
   :history true})

