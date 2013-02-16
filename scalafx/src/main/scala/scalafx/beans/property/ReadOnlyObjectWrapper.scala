/*
 * Copyright (c) 2012, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.beans.property

import javafx.beans.{property => jfxbp}
import scalafx.delegate.SFXDelegate


object ReadOnlyObjectWrapper {
  implicit def sfxReadOnlyObjectWrapper2jfx[T <: Any](roow: ReadOnlyObjectWrapper[T]) = roow.delegate

  /** Creates a new ReadOnlyObjectWrapper instance with a given initial wrapped value. */
  def apply[T <: Any](value: T) = new ReadOnlyObjectWrapper[T](new jfxbp.ReadOnlyObjectWrapper[T](value))
}


/** Wrapper for [[javafx.beans.property.ReadOnlyObjectWrapper]] */
class ReadOnlyObjectWrapper[T <: Any](override val delegate: jfxbp.ReadOnlyObjectWrapper[T])
  extends ObjectProperty[T](delegate)
  with SFXDelegate[jfxbp.ReadOnlyObjectWrapper[T]] {

  def this(bean: Object, name: String) = this(new jfxbp.ReadOnlyObjectWrapper[T](bean, name))

  def this(bean: Object, name: String, initialValue: T) =
    this(new jfxbp.ReadOnlyObjectWrapper[T](bean, name, initialValue))

  def readOnlyProperty = delegate.getReadOnlyProperty
}