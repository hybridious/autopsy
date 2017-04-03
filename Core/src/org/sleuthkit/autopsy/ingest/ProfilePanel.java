/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011-2017 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.ingest;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.ingest.IngestProfiles.IngestProfile;

/**
 * Panel to display options for profile creation and editing.
 */
class ProfilePanel extends IngestModuleGlobalSettingsPanel {

    @NbBundle.Messages({"ProfilePanel.profileDescLabel.text=Profile Description:",
        "ProfilePanel.profileNameLabel.text=Profile Name:",
        "ProfilePanel.newProfileText=NewEmptyProfile",
        "ProfilePanel.messages.profilesMustBeNamed=Ingest profile must be named.",
        "ProfilePanel.messages.profileNameContainsIllegalCharacter=Profile name contains an illegal character"})

    private final IngestJobSettingsPanel ingestSettingsPanel;
    private final IngestJobSettings settings;
    private IngestProfile profile;
    private final static String NEW_PROFILE_NAME = NbBundle.getMessage(ProfilePanel.class, "ProfilePanel.newProfileText");
    private static final List<String> ILLEGAL_NAME_CHARS = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("\\", "/", ":", "*", "?", "\"", "<", ">")));

    /**
     * Creates new form ProfilePanel
     */
    ProfilePanel() {
        initComponents();
        settings = new IngestJobSettings(NEW_PROFILE_NAME);
        ingestSettingsPanel = new IngestJobSettingsPanel(settings);
        ingestSettingsPanel.setPastJobsButtonVisible(false);
        jPanel1.add(ingestSettingsPanel, 0);

    }

    ProfilePanel(IngestProfile selectedProfile) {
        initComponents();
        profile = selectedProfile;
        profileDescArea.setText(profile.getDescription());
        profileNameField.setText(profile.getName());
        settings = new IngestJobSettings(selectedProfile.getName());
        ingestSettingsPanel = new IngestJobSettingsPanel(settings);
        ingestSettingsPanel.setPastJobsButtonVisible(false);
        jPanel1.add(ingestSettingsPanel, 0);
    }

    /**
     * Get the name of the profile.
     *
     * The name will not contain any trailing or leading spaces.
     *
     * @return
     */
    String getProfileName() {
        return profileNameField.getText().trim();
    }

    String getProfileDesc() {
        return profileDescArea.getText();
    }

    IngestJobSettings getSettings() {
        return ingestSettingsPanel.getSettings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        profileNameField = new javax.swing.JTextField();
        profileDescLabel = new javax.swing.JLabel();
        profileDescPane = new javax.swing.JScrollPane();
        profileDescArea = new javax.swing.JTextArea();
        profileNameLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jScrollPane1.setPreferredSize(new java.awt.Dimension(650, 323));

        org.openide.awt.Mnemonics.setLocalizedText(profileDescLabel, org.openide.util.NbBundle.getMessage(ProfilePanel.class, "ProfilePanel.profileDescLabel.text")); // NOI18N

        profileDescArea.setColumns(20);
        profileDescArea.setLineWrap(true);
        profileDescArea.setRows(5);
        profileDescArea.setWrapStyleWord(true);
        profileDescArea.setMinimumSize(new java.awt.Dimension(104, 22));
        profileDescArea.setName(""); // NOI18N
        profileDescArea.setPreferredSize(new java.awt.Dimension(164, 30));

        org.openide.awt.Mnemonics.setLocalizedText(profileNameLabel, org.openide.util.NbBundle.getMessage(ProfilePanel.class, "ProfilePanel.profileNameLabel.text")); // NOI18N

        jPanel1.setMinimumSize(new java.awt.Dimension(625, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(625, 450));
        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileDescLabel)
                    .addComponent(profileNameLabel)))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileNameField)
                    .addComponent(profileDescPane))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(profileNameLabel)
                .addGap(0, 0, 0)
                .addComponent(profileNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(profileDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(profileDescPane, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
  @Override
    public void removePropertyChangeListener(PropertyChangeListener l) {
        ingestSettingsPanel.removePropertyChangeListener(l);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener l) {
        ingestSettingsPanel.addPropertyChangeListener(l);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea profileDescArea;
    private javax.swing.JLabel profileDescLabel;
    private javax.swing.JScrollPane profileDescPane;
    private javax.swing.JTextField profileNameField;
    private javax.swing.JLabel profileNameLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * Save a new or edited profile.
     */
    @Override
    public void saveSettings() {
        if (profile == null) {
            IngestProfile.renameProfile(settings.getExecutionContext(), getProfileName());
        } else if (!profile.getName().equals(getProfileName())) {
            IngestProfile.renameProfile(profile.getName(), getProfileName());
        }
        profile = new IngestProfile(getProfileName(), profileDescArea.getText(), ingestSettingsPanel.getSettings().getFileIngestFilter().getName());
        IngestProfile.saveProfile(profile);
        ingestSettingsPanel.getSettings().saveAs(getProfileName());
    }

    /**
     * Save a new or edited profile.
     */
    void store() {
        saveSettings();
    }

    void load() {
    }

    /**
     * Checks that information entered constitutes a valid ingest profile.
     *
     * @return true for valid, false for invalid.
     */
    boolean isValidDefinition() {
        if (getProfileName().isEmpty()) {
            NotifyDescriptor notifyDesc = new NotifyDescriptor.Message(
                    NbBundle.getMessage(ProfilePanel.class, "ProfilePanel.messages.profilesMustBeNamed"),
                    NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(notifyDesc);
            return false;
        }
        if (!containsOnlyLegalChars(getProfileName(), ILLEGAL_NAME_CHARS)) {
            NotifyDescriptor notifyDesc = new NotifyDescriptor.Message(
                    NbBundle.getMessage(ProfilePanel.class, "ProfilePanel.messages.profileNameContainsIllegalCharacter"),
                    NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(notifyDesc);
            return false;
        }
        return true;
    }

    /**
     * Checks an input string for the use of illegal characters.
     *
     * @param toBeChecked  The input string.
     * @param illegalChars The characters deemed to be illegal.
     *
     * @return True if the string does not contain illegal characters, false
     *         otherwise.
     */
    private static boolean containsOnlyLegalChars(String toBeChecked, List<String> illegalChars) {
        for (String illegalChar : illegalChars) {
            if (toBeChecked.contains(illegalChar)) {
                return false;
            }
        }
        return true;
    }
}
