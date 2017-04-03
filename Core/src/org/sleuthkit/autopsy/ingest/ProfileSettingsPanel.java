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

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.corecomponents.AdvancedConfigurationDialog;
import org.sleuthkit.autopsy.corecomponents.OptionsPanel;
import org.sleuthkit.autopsy.coreutils.MessageNotifyUtil;
import org.sleuthkit.autopsy.ingest.IngestProfiles.IngestProfile;
import org.sleuthkit.autopsy.modules.interestingitems.FilesSet;
import org.sleuthkit.autopsy.modules.interestingitems.FilesSetsManager;

class ProfileSettingsPanel extends IngestModuleGlobalSettingsPanel implements OptionsPanel {

    @NbBundle.Messages({"ProfileSettingsPanel.title=Profile Settings",
        "ProfileSettingsPanel.profileListLabel.text=Profiles:",
        "ProfileSettingsPanel.profileDescLabel.text=Profile Description:",
        "ProfileSettingsPanel.filterNameLabel.text=Filter:",
        "ProfileSettingsPanel.selectedModulesLabel.text=Selected Ingest Modules:",
        "ProfileSettingsPanel.newProfileButton.text=New Profile",
        "ProfileSettingsPanel.editProfileButton.text=Edit Profile",
        "ProfileSettingsPanel.deleteProfileButton.text=Delete Profile",
        "ProfileSettingsPanel.messages.filterLoadFailed=Failed to load file ingest filter",
        "# {0} - profile name",
        "ProfileSettingsPanel.doFileSetsDialog.duplicateProfile.text=Profile with name {0} already exists.",
        "ProfileSettingsPanel.infoTextArea.text=An Ingest Profile runs a preconfigured set of ingest modules"
        + " on some or all of the files in a data source. Create a profile if you frequently run the same set of modules on a subset of the files."
    })

    private final DefaultListModel<IngestProfile> profilesListModel;
    private Map<String, IngestProfile> profiles;
    private ProfilePanel panel;
    private boolean canBeEnabled;  //if something can be enabled ingest is not running
    private int option = JOptionPane.CANCEL_OPTION;
    /**
     * Creates new form ProfileOptionsPanel
     */
    ProfileSettingsPanel() {
        this.profilesListModel = new DefaultListModel<>();
        initComponents();
        this.profileList.setModel(profilesListModel);
        this.profileList.addListSelectionListener(new ProfileSettingsPanel.ProfileListSelectionListener());
        ingestWarningLabel.setVisible(false);
        canBeEnabled = !IngestManager.getInstance().isIngestRunning();
        refreshButtons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileListPane = new javax.swing.JScrollPane();
        profileList = new javax.swing.JList<>();
        profileListLabel = new javax.swing.JLabel();
        newProfileButton = new javax.swing.JButton();
        editProfileButton = new javax.swing.JButton();
        deleteProfileButton = new javax.swing.JButton();
        profileDescPane = new javax.swing.JScrollPane();
        profileDescArea = new javax.swing.JTextArea();
        profileDescLabel = new javax.swing.JLabel();
        filterNameLabel = new javax.swing.JLabel();
        filterNameText = new javax.swing.JLabel();
        filterDescPane = new javax.swing.JScrollPane();
        filterDescArea = new javax.swing.JTextArea();
        selectedModulesPane = new javax.swing.JScrollPane();
        selectedModulesArea = new javax.swing.JTextArea();
        selectedModulesLabel = new javax.swing.JLabel();
        ingestWarningLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(800, 488));

        profileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        profileListPane.setViewportView(profileList);

        org.openide.awt.Mnemonics.setLocalizedText(profileListLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.profileListLabel.text")); // NOI18N

        newProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/add16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(newProfileButton, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.newProfileButton.text")); // NOI18N
        newProfileButton.setMargin(new java.awt.Insets(2, 8, 2, 8));
        newProfileButton.setMaximumSize(new java.awt.Dimension(97, 23));
        newProfileButton.setMinimumSize(new java.awt.Dimension(97, 23));
        newProfileButton.setPreferredSize(new java.awt.Dimension(97, 23));
        newProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProfileButtonActionPerformed(evt);
            }
        });

        editProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/edit16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(editProfileButton, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.editProfileButton.text")); // NOI18N
        editProfileButton.setMargin(new java.awt.Insets(2, 8, 2, 8));
        editProfileButton.setMaximumSize(new java.awt.Dimension(97, 23));
        editProfileButton.setMinimumSize(new java.awt.Dimension(97, 23));
        editProfileButton.setPreferredSize(new java.awt.Dimension(97, 23));
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });

        deleteProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/delete16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(deleteProfileButton, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.deleteProfileButton.text")); // NOI18N
        deleteProfileButton.setMargin(new java.awt.Insets(2, 8, 2, 8));
        deleteProfileButton.setPreferredSize(new java.awt.Dimension(97, 23));
        deleteProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProfileButtonActionPerformed(evt);
            }
        });

        profileDescArea.setEditable(false);
        profileDescArea.setBackground(new java.awt.Color(240, 240, 240));
        profileDescArea.setColumns(20);
        profileDescArea.setLineWrap(true);
        profileDescArea.setRows(5);
        profileDescArea.setWrapStyleWord(true);
        profileDescArea.setMinimumSize(new java.awt.Dimension(10, 22));
        profileDescPane.setViewportView(profileDescArea);

        org.openide.awt.Mnemonics.setLocalizedText(profileDescLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.profileDescLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(filterNameLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.filterNameLabel.text")); // NOI18N
        filterNameLabel.setMinimumSize(new java.awt.Dimension(30, 14));
        filterNameLabel.setPreferredSize(new java.awt.Dimension(30, 14));

        filterNameText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        filterNameText.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        filterDescPane.setAutoscrolls(true);

        filterDescArea.setEditable(false);
        filterDescArea.setBackground(new java.awt.Color(240, 240, 240));
        filterDescArea.setColumns(20);
        filterDescArea.setLineWrap(true);
        filterDescArea.setRows(5);
        filterDescArea.setWrapStyleWord(true);
        filterDescArea.setMinimumSize(new java.awt.Dimension(10, 40));
        filterDescPane.setViewportView(filterDescArea);

        selectedModulesArea.setEditable(false);
        selectedModulesArea.setBackground(new java.awt.Color(240, 240, 240));
        selectedModulesArea.setColumns(20);
        selectedModulesArea.setLineWrap(true);
        selectedModulesArea.setRows(5);
        selectedModulesArea.setWrapStyleWord(true);
        selectedModulesPane.setViewportView(selectedModulesArea);

        org.openide.awt.Mnemonics.setLocalizedText(selectedModulesLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.selectedModulesLabel.text")); // NOI18N

        ingestWarningLabel.setFont(ingestWarningLabel.getFont().deriveFont(ingestWarningLabel.getFont().getStyle() & ~java.awt.Font.BOLD, 11));
        ingestWarningLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/modules/hashdatabase/warning16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(ingestWarningLabel, org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.ingestWarningLabel.text")); // NOI18N

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane2.setFont(jScrollPane2.getFont().deriveFont(jScrollPane2.getFont().getStyle() & ~java.awt.Font.BOLD, 11));

        infoTextArea.setEditable(false);
        infoTextArea.setBackground(new java.awt.Color(240, 240, 240));
        infoTextArea.setColumns(20);
        infoTextArea.setFont(infoTextArea.getFont().deriveFont(infoTextArea.getFont().getStyle() & ~java.awt.Font.BOLD, 11));
        infoTextArea.setLineWrap(true);
        infoTextArea.setRows(3);
        infoTextArea.setText(org.openide.util.NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.infoTextArea.text")); // NOI18N
        infoTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(infoTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(newProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(editProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(deleteProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(profileListLabel))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(profileListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(profileDescLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(ingestWarningLabel)
                                                .addGap(0, 69, Short.MAX_VALUE))
                                            .addComponent(profileDescPane, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(selectedModulesPane, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(filterDescPane)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(filterNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedModulesLabel)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteProfileButton, editProfileButton, newProfileButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, profileListPane});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(profileDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profileDescPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filterNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterDescPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectedModulesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectedModulesPane, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profileListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profileListPane, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                .addGap(9, 9, 9)))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingestWarningLabel))
                        .addContainerGap())
                    .addComponent(jSeparator2)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProfileButtonActionPerformed
        doProfileDialog(null);
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_newProfileButtonActionPerformed

    private void deleteProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProfileButtonActionPerformed
        IngestProfile selectedProfile = this.profileList.getSelectedValue();
        this.profilesListModel.removeElement(selectedProfile);
        profiles.remove(selectedProfile.getName());
        IngestProfile.deleteProfile(selectedProfile);

        // Select the first of the remaining set definitions. This will cause
        // the selection listeners to repopulate the subordinate components.
        this.resetComponents();
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_deleteProfileButtonActionPerformed

    /**
     * Enable / disable buttons, so they can be disabled while ingest is
     * running.
     *
     * @param isEnabled
     */
    void enableButtons(boolean isEnabled) {
        canBeEnabled = isEnabled;  //update value of canBeEnabled to be used by refresh
        refreshButtons();
        ingestWarningLabel.setVisible(!canBeEnabled);
    }

    /**
     * Refresh displayed information.
     */
    private void resetComponents() {
        if (!this.profilesListModel.isEmpty()) {
            this.profileList.setSelectedIndex(0);
        } else {
            this.profilesListModel.clear();
            this.profileDescArea.setText("");
            this.filterDescArea.setText("");
            this.filterNameText.setText("");
            this.selectedModulesArea.setText("");
        }
        refreshButtons();
    }

    /**
     * When Ingest is not running this will change the enabled status of the
     * edit and delete buttons to reflect their current availability.
     */
    private void refreshButtons() {
        IngestProfile selectedProfile = ProfileSettingsPanel.this.profileList.getSelectedValue();
        boolean profileIsSelected = (selectedProfile != null);
        newProfileButton.setEnabled(canBeEnabled);
        editProfileButton.setEnabled(canBeEnabled && profileIsSelected);
        deleteProfileButton.setEnabled(canBeEnabled && profileIsSelected);

    }


    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        IngestProfile selectedProfile = profileList.getSelectedValue();
        doProfileDialog(selectedProfile);
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_editProfileButtonActionPerformed

    /**
     * Open a dialog for the the creation or modification of a profile.
     *
     * @param selectedProfile
     */
    private void doProfileDialog(IngestProfile selectedProfile) {
        // Create a files set defintion panel.
         final AdvancedConfigurationDialog dialog = new AdvancedConfigurationDialog(true);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //start wait cursor for ingest job settings construction
        if (selectedProfile != null) {
            // Editing an existing set definition.
            panel = new ProfilePanel(selectedProfile);
        } else {
            // Creating a new set definition.
            panel = new ProfilePanel();
        }
         dialog.addApplyButtonListener(
                    (ActionEvent e) -> {
                        panel.store();
                        option = JOptionPane.OK_OPTION;
                        dialog.close();
                    }
            );
           
        
        //end wait Cursor for ingest job settings construction
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        // Do a dialog box with the profilePanel till the user enters a name or chooses cancel
        do {
            option = JOptionPane.CANCEL_OPTION; 
            dialog.display(panel);
        } while (option == JOptionPane.OK_OPTION && !panel.isValidDefinition());

        if (option == JOptionPane.OK_OPTION) {

            // While adding new profile(selectedPRofile == null), if a profile with same name already exists, do not add to the profiles hashMap.
            // In case of editing an existing profile(selectedProfile != null), following check is not performed.
            if (this.profiles.containsKey(panel.getProfileName()) && selectedProfile == null) {
                MessageNotifyUtil.Message.error(NbBundle.getMessage(this.getClass(),
                        "ProfileSettingsPanel.doFileSetsDialog.duplicateProfile.text",
                        panel.getProfileName()));
                return;
            }
            panel.saveSettings();
            load();
        }
    }

    @Override
    public void saveSettings() {
    }

    @Override
    public void store() {
    }

    /**
     * Load the stored profile information.
     */
    @Override
    public void load() {
        int currentIndex = this.profileList.getSelectedIndex();
        this.profilesListModel.clear();
        this.profiles = new TreeMap<>();
        for (IngestProfile profile : IngestProfiles.getIngestProfiles()) {
            profilesListModel.addElement(profile);
            profiles.put(profile.getName(), profile);
        }
        if (currentIndex < 0 || currentIndex >= profilesListModel.getSize()) {
            currentIndex = 0;
        }
        refreshButtons();
        this.profileList.setSelectedIndex(currentIndex);
    }

    private final class ProfileListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            // Get the selected interesting files set and populate the set
            // components.
            IngestProfile selectedProfile = ProfileSettingsPanel.this.profileList.getSelectedValue();
            refreshButtons();
            if (selectedProfile != null) {
                profileDescArea.setText(selectedProfile.getDescription());
                filterNameText.setText(selectedProfile.getFileIngestFilter());
                try {
                    Map<String, FilesSet> fileIngestFilters = FilesSetsManager.getInstance().getCustomFileIngestFilters();
                    for (FilesSet fSet : FilesSetsManager.getStandardFileIngestFilters()) {
                        fileIngestFilters.put(fSet.getName(), fSet);
                    }
                    filterDescArea.setText(fileIngestFilters.get(selectedProfile.getFileIngestFilter()).getDescription());
                } catch (FilesSetsManager.FilesSetsManagerException ex) {
                    filterDescArea.setText(NbBundle.getMessage(ProfileSettingsPanel.class, "ProfileSettingsPanel.messages.filterLoadFailed"));
                }
                selectedModulesArea.setText("");
                for (String moduleName : IngestJobSettings.getEnabledModules(selectedProfile.getName())) {
                    selectedModulesArea.append(moduleName + "\n");
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteProfileButton;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JTextArea filterDescArea;
    private javax.swing.JScrollPane filterDescPane;
    private javax.swing.JLabel filterNameLabel;
    private javax.swing.JLabel filterNameText;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JLabel ingestWarningLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton newProfileButton;
    private javax.swing.JTextArea profileDescArea;
    private javax.swing.JLabel profileDescLabel;
    private javax.swing.JScrollPane profileDescPane;
    private javax.swing.JList<IngestProfile> profileList;
    private javax.swing.JLabel profileListLabel;
    private javax.swing.JScrollPane profileListPane;
    private javax.swing.JTextArea selectedModulesArea;
    private javax.swing.JLabel selectedModulesLabel;
    private javax.swing.JScrollPane selectedModulesPane;
    // End of variables declaration//GEN-END:variables
}
