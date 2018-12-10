regExps = {
"exercise_1": /[A-Z][a-z]+/,
"exercise_2": /088[1789]\d{6}/,
"exercise_3": /[^0-1]+/,
"exercise_4": /^[a-zA-Z][\w.+]{2,13}$/,
"exercise_5": /^(?:[0-9]|(?:[1-9][0-9])|(?:[1-9][0-9][0-9])|(?:[1-1][0-4][0-9][0-9])|(?:1500))$/,
"exercise_6": /class=['"](.*)['"]/
};
cssSelectors = {
"exercise_1": "item > java",
"exercise_2": "different > java",
"exercise_3": "item > java > tag",
"exercise_4": "css > item:nth-child(3)",
"exercise_5": "item > tag > java:nth-child(2)",
"exercise_6": "item#someId > item > item > item > item",
"exercise_7": "different#diffId2 > java:nth-child(2)",
"exercise_8": "item#someId"
};
