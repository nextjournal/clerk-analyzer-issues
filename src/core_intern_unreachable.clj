(ns core-intern-unreachable
  (:require [nextjournal.clerk :as clerk]
            [nextjournal.clerk.analyzer :as clerk.analyzer]
            [macros :refer [intern-42]]))

(intern-42 the-answer)

the-answer

(comment

  (clerk.analyzer/analyze '(intern-42 the-answer))

  (clojure.tools.analyzer.jvm/macroexpand-all '(intern-42 the-answer))

  (doseq [[n _] (ns-publics *ns*)] (ns-unmap *ns* n))
  )
