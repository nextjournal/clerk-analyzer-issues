(ns hugsql
  {:nextjournal.clerk/no-cache true}
  (:require [hugsql.core :as hugsql]
            [nextjournal.clerk.analyzer]))

(hugsql/def-db-fns "query.sql")

(fn? hello)

;; `show!` -> could not resolve var `hello`

;;[clojure.tools.analyzer.passes.jvm.validate$eval10527$fn__10529 invoke "validate.clj" 28]
;;[clojure.lang.MultiFn invoke "MultiFn.java" 229]
;;[clojure.tools.analyzer.passes.jvm.validate$validate invokeStatic "validate.clj" 265]
;;[clojure.tools.analyzer.passes.jvm.validate$validate invoke "validate.clj" 240]
;;[clojure.lang.Var invoke "Var.java" 384]
;;[clojure.tools.analyzer.passes$compile_passes$fn__8825$fn__8830 invoke "passes.clj" 167]
;;...
;;[clojure.tools.analyzer.jvm$analyze invokeStatic "jvm.clj" 500]
;;[clojure.tools.analyzer.jvm$analyze invoke "jvm.clj" 480]
;;[nextjournal.clerk.analyzer$analyze_form invokeStatic "analyzer.clj" 101]

(comment
  (do *e)
  (doseq [[n _] (ns-publics *ns*)]
    (ns-unmap *ns* n))

  (-> (nextjournal.clerk.analyzer/analyze '(hugsql/def-db-fns "query.sql"))
      :deps)

  ;; we cannot reach clojure.core/intern from this form
  (clojure.tools.analyzer.jvm/macroexpand-all
   '(hugsql/def-db-fns "query.sql"))

  ;; I can reach at most
  ;; hugsql.core/intern-db-fn
  )
