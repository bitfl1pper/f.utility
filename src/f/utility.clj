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

(defn filenames
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

(defn spitcol
  "Spit a collection to a file
   Useful for spiting out returns such as get all links

   fname:   filename
       f:   function
     ext:   desired file extension"
  [filename collection]
  (spit filename
        (clojure.string/join (map #(str % "\n") collection))))

(defn tokenize
  [s]
  (clojure.string/split s #"\s+"))

(defn tokens-in-col
  [col]
  (flatten (map (partial tokenize) col)))

(defn tokens-in-file
  [file]
  (drop-empty (tokens-in-col (read-file-by-line file))))

(defn ngram
  [n col]
  (partition n 1 col))

(defn ngrams-in-file
  [n file]
  (partition n 1 (tokens-in-file file)))
