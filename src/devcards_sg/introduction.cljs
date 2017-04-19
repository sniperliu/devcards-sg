(ns devcards-sg.introduction
  (:require [devcards.core :as dc :include-macros true]
            [reagent.core :as rg]))

(dc/defcard Title
  "<div style='width: 1000px; height: 600px; display:flex; flex-flow: row wrap; align-items: center; justify-content: center;'>
     <h1 style='width: 100%; text-align: center' markdown='1'>Clojurescript workflow with devcards</h1>
     <h2 style='width: 100%; text-align: center' markdown='2'>author: Liu Hao@Flybot</h2>
     <h2 style='width: 100%; text-align: center'>18/04/2017</h2>
   </div>")

(dc/defcard What's-devcard?
  "<image src='./images/question.png' style='width: 100%'>")

(dc/defcard Devcard
  "## Devcards is a library could work with live code reloading tools (figwheel, boot-reload, repl...) and facilitate TDD & interactive live clojurescript development.

   As clojure/clojurescript developer

   * We loves library & functions - to start, just use defcard
     ```clojure
     (defcard Demo
       \"... Markdown ...\"
       (foo p1 p2 ...))
     ```
   * We don't like documentation - it encourages and facilitate documentation.
     - Markdown docs
     - cljs.test integration
     - Support reagent, om directly
     - Advanced feature like auto-detection and dispatch

   * We loves live coding - it's very easy to integrate with figwheel or other repl
     - Time travel
     - Data display")

(dc/defcard Start
  "# To start use dev cards

   ## setup

   * From fresh

   ```shell
   # as simple as

   lein new devcards your-project

   lein figwheel

   open http://localhost:3449/cards.html
   ```
   * Existing project with figwheel

   ```clojure
   ;; project.clj
   :cljsbuild {
     :builds [{:id devcards
               :figwheel { :devcards true }
               :compiler {
                 :main \"devcards-example.core\"
                 :output-to \"resources/public/js/cards.js\"
                 ...}}]}
   ```
   ```html
   <!-- cards.html -->
   <html>
     ...
     <script src=\"js/cards.js\" type=\"text/javascript\"></script>
   </html>
   ```

   * Without figwheel
   ```
   ;; project.clj
   :cljsbuild {
     :builds [{:id devcards
               :compiler {
                 :main \"devcards-example.core\"
                 :devcards true
                 :output-to \"resources/public/js/cards.js\"
                 ...}}]}
   ```

   ```clojure
   (devcards.core/start-devcard-ui!)
   ```

   ## In your code

   ```clojure
   (:require-macros
     [devcards.core :as dc :refer [defcard]])
   ;; or
   (:requrie
     [devcards.core :as dc :include-macros true])
   ```")

(dc/defcard Reference
  "## Reference

   [Devcards](https://github.com/bhauman/devcards)

   [Live Demo](http://rigsomelight.com/devcards/#!/)

   [Very good & attractive exmample](http://timothypratley.github.io/reanimated/#!/timothypratley.reanimated.examples)")
