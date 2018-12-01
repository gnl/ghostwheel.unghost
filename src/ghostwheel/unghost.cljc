(ns ghostwheel.unghost)

(defn clean-defn
  "This removes the gspec and returns a
  clean defn for use in production builds."
  [op forms]
  (let [single-arity? (fn [fn-forms] (boolean (some vector? fn-forms)))
        strip-gspec   (fn [body] (let [[args _gspec & more] body]
                                   (cons args more)))]
    (->> (if (single-arity? forms)
           (let [[head-forms body-forms] (split-with (complement vector?) forms)]
             `(~op ~@head-forms ~@(strip-gspec body-forms)))
           (let [[head-forms body-forms tail-attr-map] (partition-by (complement seq?) forms)]
             `(~op ~@head-forms ~@(map strip-gspec body-forms) ~@tail-attr-map)))
         (remove nil?))))
