(ns f.utility)

;;;; Yet another utility library: f.utility

;;; Drop Stuff

(defn dropnil
  "Drops nil values."
  [col]
  (remove nil? col))

(defn dropif
  "Drops values from a collection if they are equal to "
  [val col]
  (remove #(= val %) col))

(defn dropif-not
  "Drops values from a collection if they are not equal to "
  [val col]
  (filter #(= val %) col))

(defn dropif-less
  "Drops values that are less than "
  [val col]
  (remove #(> val %) col))

(defn dropif-greater
  "Drops values that are greater than "
  [val col]
  (remove #(< val %) col))

;;; Uncat

(defn between? [val r0 r1]
  (if (or (and (< val r0) (> val r1))
          (and (> val r0) (< val r1)))
    true
    false))

;;; Count Stuff

(defn unique
  "Counts how many distinct items in col."
  [col]
  (count (distinct col)))

;;; Load / Read Stuff

(defn read-file-by-line
  "Read file, line by line.
   As seen on stackoverflow!"
  [file]
  (with-open [rdr (clojure.java.io/reader file)]
    (doall (line-seq rdr))))

;; File stuff

(defn files
  "Takes a file path and returns a sequence of
   Java file objects (the files in dir)"
  [path]
  (file-seq (clojure.java.io/file path)))

(defn file-names
  "Takes a collection of java file objects
   and returns a list of file names."
  [files]
  (map #(.getName %) fls))


;; other

(defn seefreq
  "Takes the frequencies of items in a collection, sorts
   the resulting collection by #, and reverses the list."
  [col]
  (reverse (sort-by val (frequencies col))))
