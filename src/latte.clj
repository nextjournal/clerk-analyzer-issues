(ns latte
  (:require [nextjournal.clerk :as clerk]
            [latte.core :refer [definition]]))

(definition Set
  "Sets with elements in the type T"
  [[T :type]]
  (==> T :type))

(definition Powerset
  "Collections of sets"
  [[T :type]]
  (==> (Set T) :type))

;; dependent definitions need their dependencies to be bound to a valid LaTTe term at macro expansion
;; in order to validate the type signature
;; see also `src/dependent_defs.clj`

(comment
  (clerk/serve! {:port 7788})
  ;; `clerk/show!` throws
  ;; Execution error (ExceptionInfo) at latte-kernel.presyntax/parse-compound-term (presyntax.cljc:185).
  ;; Not a LaTTe definition (please report)

  *e  ;; =>
  ;;[latte_kernel.presyntax$parse_compound_term invokeStatic "presyntax.cljc" 185]
  ;;[latte_kernel.presyntax$parse_compound_term invoke "presyntax.cljc" 167]
  ;;[latte_kernel.presyntax$parse_term invokeStatic "presyntax.cljc" 78]
  ;;[latte_kernel.presyntax$parse_term invoke "presyntax.cljc" 68]
  ;;[latte_kernel.presyntax$parse_terms$fn__6021 invoke "presyntax.cljc" 277]
  ;;...
  ;;[clojure.tools.analyzer.jvm$macroexpand_1 invokeStatic "jvm.clj" 192]
  ;;[clojure.tools.analyzer.jvm$macroexpand_1 invoke "jvm.clj" 167]
  ;;[nextjournal.clerk.analyzer$analyze$mexpander__16126 invoke "analyzer.clj" 111]

  )
