package com.piotr.androidtemplate.base.ui.extensions

import java.util.Locale

private val diacriticReplacements = mapOf(
  'ą' to 'a',
  'ć' to 'c',
  'ę' to 'e',
  'ł' to 'l',
  'ń' to 'n',
  'ó' to 'o',
  'ś' to 's',
  'ź' to 'z',
  'ż' to 'z',
  'Ą' to 'A',
  'Ć' to 'C',
  'Ę' to 'E',
  'Ł' to 'L',
  'Ń' to 'N',
  'Ó' to 'O',
  'Ś' to 'S',
  'Ź' to 'Z',
  'Ż' to 'Z'
)

fun String.localizedFormat(vararg args: Any?): String =
  String.format(Locale.getDefault(), this, *args)

fun String.unaccented(): String = map {
  diacriticReplacements[it] ?: it
}.joinToString(separator = "")