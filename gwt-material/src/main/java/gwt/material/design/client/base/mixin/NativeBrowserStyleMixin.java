/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.client.base.mixin;

import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.base.HasNativeBrowserStyle;

public class NativeBrowserStyleMixin<T extends UIObject & HasNativeBrowserStyle> extends AbstractMixin<T> implements HasNativeBrowserStyle {

    private Widget target;
    private ToggleStyleMixin<Widget> toggleNativeBrowserStyleMixin;

    public NativeBrowserStyleMixin(final T widget) {
        super(widget);
    }

    public NativeBrowserStyleMixin(final T widget, Widget target) {
        this(widget);

        this.target = target;
    }

    @Override
    public void setNativeBrowserStyle(boolean value) {
        getToggleNativeBrowserStyleMixin().setOn(value);
    }

    @Override
    public boolean isNativeBrowserStyle() {
        return getToggleNativeBrowserStyleMixin().isOn();
    }

    public ToggleStyleMixin<Widget> getToggleNativeBrowserStyleMixin() {
        if (toggleNativeBrowserStyleMixin == null) {
            if (target != null) {
                toggleNativeBrowserStyleMixin = new ToggleStyleMixin(target, "browser-default");
            } else {
                toggleNativeBrowserStyleMixin = new ToggleStyleMixin(uiObject, "browser-default");
            }
        }
        return toggleNativeBrowserStyleMixin;
    }
}