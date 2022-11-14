(ns macros)

(defmacro dep-def [name & deps]
  (assert (every? #(some-> % resolve bound?) deps)
          "All deps must to be defined and bound at macro-expansion!")
  `(def ~name {:name '~name :refs '~deps}))

(defn do-intern-42 [name] (intern *ns* name 42))
(defmacro intern-42 [name] `(do-intern-42 '~name))
